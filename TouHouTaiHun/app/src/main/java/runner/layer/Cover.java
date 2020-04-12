package runner.layer;

import com.badlogic.gdx.math.*;
import java.util.*;
import runner.*;
import runner.layer.*;

public class Cover implements Cloneable {
        private float[] conditions = new float[5];
        private float[] results = new float[11];
        private int clcount;
        private int clwait;
        public boolean NeedDelete;
        public int Searched;
        public int id;
        public int childid;
        public int parentid;
        public int bindid;
        public boolean Deepbind;
        public boolean Deepbinded;
        public int parentcolor;
        public float x;
        public float y;
        public int time;
        public int begin;
        public int life;
        public int halfw;
        public int halfh;
        public boolean Circle;
        public int type;
        public int controlid;
        public float speed;
        public float speedd;
        public float speedx;
        public float speedy;
        public Vector2 speedds;
        public float aspeed;
        public float aspeedx;
        public float aspeedy;
        public float aspeedd;
        public Vector2 aspeedds;
        public Cover rand;
        public ArrayList<Event> Parentevents;
        public ArrayList<COExecution> Eventsexe;
        public ArrayList<Event> Sonevents;
        public Cover copys;

        public Cover() {
        }

        public Cover(float xs,float ys,int pc) {
            rand=new Cover();
            Parentevents=new ArrayList<Event>();
            Sonevents=new ArrayList<Event>();
            Eventsexe=new ArrayList<COExecution>();
            x=xs;
            y=ys;
            parentcolor=pc;
            begin=Layer.LayerArray.get(parentid).begin;
            life=Layer.LayerArray.get(parentid).end-Layer.LayerArray.get(parentid).begin+1;
            halfw=100;
            halfh=100;
            type=0;
            controlid=1;
            bindid=-1;
            speed=0.0f;
            speedd=0.0f;
            aspeed=0.0f;
            aspeedd=0.0f;
            Circle=false;
        }

        public void Update() {
            if(clcount==1) {
                ++clwait;
                if(clwait>15) {
                    clwait=0;
                    clcount=0;
                }
            }
            if(!Time.Playing) {
                childid=0;
                aspeedx=aspeed*(float)Math.cos(MathHelper.ToRadians(aspeedd));
                aspeedy=aspeed*(float)Math.sin(MathHelper.ToRadians(aspeedd));
                speedx=speed*(float)Math.cos(MathHelper.ToRadians(speedd));
                speedy=speed*(float)Math.sin(MathHelper.ToRadians(speedd));
                begin=(int)MathHelper.Clamp((float)begin,(float)Layer.LayerArray.get(parentid).begin,(float)(1+Layer.LayerArray.get(parentid).end-Layer.LayerArray.get(parentid).begin));
                life=(int)MathHelper.Clamp((float)life,1f,(float)(Layer.LayerArray.get(parentid).end-Layer.LayerArray.get(parentid).begin+2-begin));
            }
            if(bindid!=-1&&bindid>=Layer.LayerArray.get(parentid).BatchArray.size()) {
                bindid=-1;
                Deepbind=false;
            }
            if(!Time.Playing)
                return;
            if(Deepbinded)
                ++time;
            if(!(!Deepbinded&Time.now>=begin&Time.now<=begin+life-1)&&!(Deepbinded&time>=begin&time<=begin+life-1)&&!Deepbind)
                return;
            if(!Deepbind&!Deepbinded)
                time=Time.now-begin+1;
            if(!Deepbind) {
                speedx+=aspeedx;
                speedy+=aspeedy;
                x+=speedx;
                y+=speedy;
                conditions[0]=!Deepbinded ? (float)time : (float)(time-begin+1);
                conditions[1]=x+16f;
                conditions[2]=y+16f;
                conditions[3]=halfw;
                conditions[4]=halfh;
                results[0]=halfw;
                results[1]=halfh;
                results[2]=0.0f;
                results[3]=speed;
                results[4]=speedd;
                results[5]=aspeed;
                results[6]=aspeedd;
                results[7]=type;
                results[8]=controlid;
                results[9]=x-4f;
                results[10]=y+16f;
                for(Event parentevent : Parentevents) {
                    if(parentevent.t<=0)
                        parentevent.t=1;
                    if(time%parentevent.t==0)
                        ++parentevent.loop;
                    for(EventRead result : parentevent.results) {
                        if(result.special==4) {
                            if(result.changevalue==9)
                                result.res=Player.position.x;
                            if(result.changevalue==10)
                                result.res=Player.position.y;
                            if(result.changevalue==4)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x-4f,y+16f));
                            if(result.changevalue==6)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x-4f,y+16f));
                        }
                        if(result.opreator.equals(">")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    } else
                                        continue;
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    } else
                                        continue;
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    } else
                                        continue;
                                }
                            } else if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                COExecution coExecution = new COExecution();
                                if(!result.noloop) {
                                    if(result.time>0) {
                                        --result.time;
                                        if(result.time==0)
                                            result.noloop=true;
                                    }
                                    coExecution.parentid=parentid;
                                    coExecution.id=id;
                                    coExecution.change=result.change;
                                    coExecution.changetype=result.changetype;
                                    coExecution.changevalue=result.changevalue;
                                    coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                    coExecution.region=results[result.changename]+"";
                                    coExecution.time=result.times;
                                    coExecution.ctime=coExecution.time;
                                    Eventsexe.add(coExecution);
                                } else
                                    continue;
                            }
                        }
                        if(result.opreator.equals("=")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    } else
                                        continue;
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    } else
                                        continue;
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    } else
                                        continue;
                                }
                            } else if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                COExecution coExecution = new COExecution();
                                if(!result.noloop) {
                                    if(result.time>0) {
                                        --result.time;
                                        if(result.time==0)
                                            result.noloop=true;
                                    }
                                    coExecution.parentid=parentid;
                                    coExecution.id=id;
                                    coExecution.change=result.change;
                                    coExecution.changetype=result.changetype;
                                    coExecution.changevalue=result.changevalue;
                                    coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                    coExecution.region=results[result.changename]+"";
                                    coExecution.time=result.times;
                                    coExecution.ctime=coExecution.time;
                                    Eventsexe.add(coExecution);
                                } else
                                    continue;
                            }
                        }
                        if(result.opreator.equals("<")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        }
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    }
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        }
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    }
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        COExecution coExecution = new COExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            coExecution.parentid=parentid;
                                            coExecution.id=id;
                                            coExecution.change=result.change;
                                            coExecution.changetype=result.changetype;
                                            coExecution.changevalue=result.changevalue;
                                            coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                            coExecution.region=results[result.changename]+"";
                                            coExecution.time=result.times;
                                            coExecution.ctime=coExecution.time;
                                            Eventsexe.add(coExecution);
                                        }
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    COExecution coExecution = new COExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        coExecution.parentid=parentid;
                                        coExecution.id=id;
                                        coExecution.change=result.change;
                                        coExecution.changetype=result.changetype;
                                        coExecution.changevalue=result.changevalue;
                                        coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                        coExecution.region=results[result.changename]+"";
                                        coExecution.time=result.times;
                                        coExecution.ctime=coExecution.time;
                                        Eventsexe.add(coExecution);
                                    }
                                }
                            } else if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                COExecution coExecution = new COExecution();
                                if(!result.noloop) {
                                    if(result.time>0) {
                                        --result.time;
                                        if(result.time==0)
                                            result.noloop=true;
                                    }
                                    coExecution.parentid=parentid;
                                    coExecution.id=id;
                                    coExecution.change=result.change;
                                    coExecution.changetype=result.changetype;
                                    coExecution.changevalue=result.changevalue;
                                    coExecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.NextDouble());
                                    coExecution.region=results[result.changename]+"";
                                    coExecution.time=result.times;
                                    coExecution.ctime=coExecution.time;
                                    Eventsexe.add(coExecution);
                                }
                            }
                        }
                    }
                }
                for(int index = 0;index<Eventsexe.size();++index) {
                    if(!Eventsexe.get(index).NeedDelete) {
                        Eventsexe.get(index).Update(this);
                    } else {
                        Eventsexe.remove(index);
                        --index;
                    }
                }
            }
            if(bindid==-1) {
                for(Barrage barrage : Layer.LayerArray.get(parentid).Barrages) {
                    if(((barrage.Cover&!barrage.IsLase ? 1 : 0)&(barrage.time>15 ? 1 : (!barrage.Mist ? 1 : 0))&(!barrage.NeedDelete ? 1 : 0))!=0) {
                        if(Circle) {
                            if(type==0) {
                                if(Math.sqrt(((double)x-4.0-(double)barrage.x)*((double)x-4.0-(double)barrage.x)+((double)y+16.0-(double)barrage.y)*((double)y+16.0-(double)barrage.y))<=(double)Math.Max(halfw,halfh)) {
                                    if(!barrage.Covered.contains(id)) {
                                        for(int idx = 0;idx<Sonevents.size();++idx) {
											Event ev=new Event(idx);
											ev.t=Sonevents.get(idx).t;
											ev.addtime=Sonevents.get(idx).addtime;
											ev.events=Sonevents.get(idx).events;
											ev.results=Sonevents.get(idx).results;
											ev.index=Sonevents.get(idx).index;
											ev.special=id;
                                            barrage.Events.add(ev);
                                            barrage.Covered.add(id);
                                        }
                                    }
                                } else {
                                    if(barrage.Covered.contains(id)) {
                                        for(int index = 0;index<barrage.Events.size();++index) {
                                            if(barrage.Events.get(index).special==id) {
                                                barrage.Events.remove(index);
                                                --index;
                                            }
                                        }
                                    }
                                    barrage.Covered.remove(id);
                                }
                            } else if(type==1) {
                                if(barrage.parentid==controlid-1&Math.sqrt(((double)x-4.0-(double)barrage.x)*((double)x-4.0-(double)barrage.x)+((double)y+16.0-(double)barrage.y)*((double)y+16.0-(double)barrage.y))<=(double)Math.Max(halfw,halfh)) {
                                    if(!barrage.Covered.contains(id)) {
                                        for(int idx = 0;idx<Sonevents.size();++idx) {
											Event ev=new Event(idx);
											ev.t=Sonevents.get(idx).t;
											ev.addtime=Sonevents.get(idx).addtime;
											ev.events=Sonevents.get(idx).events;
											ev.results=Sonevents.get(idx).results;
											ev.index=Sonevents.get(idx).index;
											ev.special=id;
                                            barrage.Events.add(ev);
                                            barrage.Covered.add(id);
                                        }
                                    }
                                } else {
                                    if(barrage.Covered.contains(id)) {
                                        for(int index = 0;index<barrage.Events.size();++index) {
                                            if(barrage.Events.get(index).special==id) {
                                                barrage.Events.remove(index);
                                                --index;
                                            }
                                        }
                                    }
                                    barrage.Covered.remove(id);
                                }
                            }
                        } else if(type==0) {
                            if((double)Math.abs(x-4f-barrage.x)<=(double)halfw&(double)Math.abs(y+16f-barrage.y)<=(double)halfh) {
                                if(!barrage.Covered.contains(id)) {
                                    for(int idx = 0;idx<Sonevents.size();++idx) {
                                        Event ev=new Event(idx);
										ev.t=Sonevents.get(idx).t;
										ev.addtime=Sonevents.get(idx).addtime;
										ev.events=Sonevents.get(idx).events;
										ev.results=Sonevents.get(idx).results;
										ev.index=Sonevents.get(idx).index;
										ev.special=id;
										barrage.Events.add(ev);
										barrage.Covered.add(id);
                                    }
                                }
                            } else {
                                if(barrage.Covered.contains(id)) {
                                    for(int index = 0;index<barrage.Events.size();++index) {
                                        if(barrage.Events.get(index).special==id) {
                                            barrage.Events.remove(index);
                                            --index;
                                        }
                                    }
                                }
                                barrage.Covered.remove(id);
                            }
                        } else if(type==1) {
                            if(barrage.parentid==controlid-1&(double)Math.abs(x-4f-barrage.x)<=(double)halfw&(double)Math.abs(y+16f-barrage.y)<=(double)halfh) {
                                if(!barrage.Covered.contains(id)) {
                                    for(int idx = 0;idx<Sonevents.size();++idx) {
                                        Event ev=new Event(idx);
										ev.t=Sonevents.get(idx).t;
										ev.addtime=Sonevents.get(idx).addtime;
										ev.events=Sonevents.get(idx).events;
										ev.results=Sonevents.get(idx).results;
										ev.index=Sonevents.get(idx).index;
										ev.special=id;
										barrage.Events.add(ev);
										barrage.Covered.add(id);
                                    }
                                }
                            } else {
                                if(barrage.Covered.contains(id)) {
                                    for(int index = 0;index<barrage.Events.size();++index) {
                                        if(barrage.Events.get(index).special==id) {
                                            barrage.Events.remove(index);
                                            --index;
                                        }
                                    }
                                }
                                barrage.Covered.remove(id);
                            }
                        }
                    }
                }
            } else {
                int num1 = 1000;
                int num2 = 0;
                for(Barrage barrage1 : Layer.LayerArray.get(parentid).Barrages) {
                    if(!barrage1.IsLase&barrage1.parentid==bindid&!barrage1.NeedDelete) {
                        if(Deepbind) {
                            if(barrage1.cover!=null) {
                                barrage1.cover.x=barrage1.x;
                                barrage1.cover.y=barrage1.y;
                                barrage1.cover.Update();
                            } else {
                                barrage1.cover=BindClone();
                                barrage1.cover.id=childid;
                                barrage1.cover.Deepbind=false;
                                barrage1.cover.Deepbinded=true;
                                barrage1.cover.bindid=-1;
                            }
                        } else if(barrage1.time>=15||!barrage1.Mist) {
                            for(Barrage barrage2 : Layer.LayerArray.get(parentid).Barrages) {
                                if(((barrage2.id!=barrage1.id&barrage2.Cover&!barrage2.IsLase ? 1 : 0)&(barrage2.time>15 ? 1 : (!barrage2.Mist ? 1 : 0))&(!barrage2.NeedDelete ? 1 : 0))!=0) {
                                    if(Circle) {
                                        if(type==0) {
                                            if(Math.sqrt(((double)barrage1.x-(double)barrage2.x)*((double)barrage1.x-(double)barrage2.x)+((double)barrage1.y-(double)barrage2.y)*((double)barrage1.y-(double)barrage2.y))<=(double)Math.Max(halfw,halfh)) {
                                                if(!barrage2.Covered.contains(num1)) {
                                                    for(int idx = 0;idx<Sonevents.size();++idx) {
														Event ev=new Event(idx);
														ev.t=Sonevents.get(idx).t;
														ev.addtime=Sonevents.get(idx).addtime;
														ev.events=Sonevents.get(idx).events;
														ev.results=Sonevents.get(idx).results;
														ev.index=Sonevents.get(idx).index;
														ev.special=barrage2.id;
														barrage2.Events.add(ev);
														barrage2.Covered.add(num1);
                                                        ++num2;
                                                    }
                                                }
                                            } else {
                                                if(barrage2.Covered.contains(num1)) {
                                                    for(int index = 0;index<barrage2.Events.size();++index) {
                                                        if(barrage2.Events.get(index).special==barrage2.id) {
                                                            barrage2.Events.remove(index);
                                                            --index;
                                                        }
                                                    }
                                                }
                                                barrage2.Covered.remove(num1);
                                            }
                                        } else if(type==1) {
                                            if(barrage2.parentid==controlid-1&Math.sqrt(((double)barrage1.x-(double)barrage2.x)*((double)barrage1.x-(double)barrage2.x)+((double)barrage1.y-(double)barrage2.y)*((double)barrage1.y-(double)barrage2.y))<=(double)Math.Max(halfw,halfh)) {
                                                if(!barrage2.Covered.contains(num1)) {
                                                    for(int idx = 0;idx<Sonevents.size();++idx) {
                                                        Event ev=new Event(idx);
														ev.t=Sonevents.get(idx).t;
														ev.addtime=Sonevents.get(idx).addtime;
														ev.events=Sonevents.get(idx).events;
														ev.results=Sonevents.get(idx).results;
														ev.index=Sonevents.get(idx).index;
														ev.special=barrage2.id;
														barrage2.Events.add(ev);
														barrage2.Covered.add(num1);
                                                    }
                                                }
                                            } else {
                                                if(barrage2.Covered.contains(num1)) {
                                                    for(int index = 0;index<barrage2.Events.size();++index) {
                                                        if(barrage2.Events.get(index).special==barrage2.id) {
                                                            barrage2.Events.remove(index);
                                                            --index;
                                                        }
                                                    }
                                                }
                                                barrage2.Covered.remove(num1);
                                            }
                                        }
                                    } else if(type==0) {
                                        if((double)Math.abs(barrage1.x-barrage2.x)<=(double)halfw&(double)Math.abs(barrage1.y-barrage2.y)<=(double)halfh) {
                                            if(!barrage2.Covered.contains(num1)) {
                                                for(int idx = 0;idx<Sonevents.size();++idx) {
                                                    Event ev=new Event(idx);
													ev.t=Sonevents.get(idx).t;
													ev.addtime=Sonevents.get(idx).addtime;
													ev.events=Sonevents.get(idx).events;
													ev.results=Sonevents.get(idx).results;
													ev.index=Sonevents.get(idx).index;
													ev.special=barrage2.id;
													barrage2.Events.add(ev);
													barrage2.Covered.add(num1);
                                                }
                                            }
                                        } else {
                                            if(barrage2.Covered.contains(num1)) {
                                                for(int index = 0;index<barrage2.Events.size();++index) {
                                                    if(barrage2.Events.get(index).special==barrage2.id) {
                                                        barrage2.Events.remove(index);
                                                        --index;
                                                    }
                                                }
                                            }
                                            barrage2.Covered.remove(num1);
                                        }
                                    } else if(type==1) {
                                        if(barrage2.parentid==controlid-1&(double)Math.abs(barrage1.x-barrage2.x)<=(double)halfw&(double)Math.abs(barrage1.y-barrage2.y)<=(double)halfh) {
                                            if(!barrage2.Covered.contains(num1)) {
                                                for(int idx = 0;idx<Sonevents.size();++idx) {
                                                    Event ev=new Event(idx);
													ev.t=Sonevents.get(idx).t;
													ev.addtime=Sonevents.get(idx).addtime;
													ev.events=Sonevents.get(idx).events;
													ev.results=Sonevents.get(idx).results;
													ev.index=Sonevents.get(idx).index;
													ev.special=barrage2.id;
													barrage2.Events.add(ev);
													barrage2.Covered.add(num1);
                                                }
                                            }
                                        } else {
                                            if(barrage2.Covered.contains(num1)) {
                                                for(int index = 0;index<barrage2.Events.size();++index) {
                                                    if(barrage2.Events.get(index).special==barrage2.id) {
                                                        barrage2.Events.remove(index);
                                                        --index;
                                                    }
                                                }
                                            }
                                            barrage2.Covered.remove(num1);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ++num1;
                    ++childid;
                }
            }
        }

        public Cover BindClone() {
            Cover cover = Copy();
            cover.Parentevents=new ArrayList<Event>();
            for(Event parentevent : Parentevents)
                cover.Parentevents.add(parentevent.Clone());
            cover.Eventsexe=new ArrayList<COExecution>();
            for(COExecution coExecution : Eventsexe)
                cover.Eventsexe.add(coExecution.Clone());
            cover.Sonevents=new ArrayList<Event>();
            for(Event sonevent : Sonevents)
                cover.Sonevents.add(sonevent.Clone());
            return cover;
        }	

        public Cover Clone() {
			try {
				Cover c=(Cover)super.clone();
				c.conditions=conditions.clone();
				c.results=results.clone();
				c.speedds=speedds.cpy();
				c.aspeedds=aspeedds.cpy();
				c.rand=rand.Clone();
				c.copys=copys.Clone();
				c.Parentevents=new ArrayList<>();
				for(Event e:Parentevents){
					c.Parentevents.add(e.Clone());
				}
				c.Eventsexe =new ArrayList<>();
				for(COExecution e:Eventsexe){
					c.Eventsexe.add(e.Clone());
				}
				c.Sonevents=new ArrayList<>();
				for(Event e:Sonevents){
					c.Sonevents.add(e.Clone());
				}
				return c;
			} catch (CloneNotSupportedException e) {
				return null;
			}
        }

        public Cover Copy() {
            try {
				return (Cover)super.clone();
			} catch (CloneNotSupportedException e) {
				return null;
			}
        }
		
        public void PreviewUpdate() {
            if(Time.now<begin||Time.now>begin+life-1)
                return;
            speedx+=aspeedx;
            speedy+=aspeedy;
            x+=speedx;
            y+=speedy;
        }
    }
