package runner.layer;
import com.badlogic.gdx.math.*;
import java.util.*;
import runner.*;

public class Lase {
        public int bindid = -1;
        private float[] conditions = new float[10];
        private float[] results = new float[24];
        private int clcount;
        private int clwait;
        public int Searched;
        public boolean NeedDelete;
        public int id;
        public int parentid;
        public int parentcolor;
        public boolean Binding;
        public boolean Bindwithspeedd;
        public boolean Deepbind;
        public boolean Deepbinded;
        public float x;
        public float y;
        public int time;
        public int begin;
        public int life;
        public float r;
        public float rdirection;
        public Vector2 rdirections;
        public int tiao;
        public int t;
        public float fdirection;
        public Vector2 fdirections;
        public int range;
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
        public int sonlife;
        public float type;
        public float longs;
        public float wscale;
        public float alpha;
        public boolean Ray;
        public float sonspeed;
        public float sonspeedd;
        public Vector2 sonspeedds;
        public float sonaspeed;
        public float sonaspeedd;
        public Vector2 sonaspeedds;
        public float xscale;
        public float yscale;
        public boolean Blend;
        public boolean Outdispel;
        public boolean Invincible;
        public Lase rand;
        public ArrayList<Event> Parentevents;
        public ArrayList<LExecution> Eventsexe;
        public ArrayList<Event> Sonevents;
        public Lase copys;

        public Lase() {
        }

        public Lase(float xs,float ys,int pc) {
            rand=new Lase();
            Parentevents=new ArrayList<Event>();
            Sonevents=new ArrayList<Event>();
            Eventsexe=new ArrayList<LExecution>();
            x=xs;
            y=ys;
            parentcolor=pc;
            begin=Layer.LayerArray.get(parentid).begin;
            life=Layer.LayerArray.get(parentid).end-Layer.LayerArray.get(parentid).begin+1;
            r=0.0f;
            rdirection=0.0f;
            tiao=1;
            t=5;
            fdirection=0.0f;
            range=360;
            speed=0.0f;
            speedd=0.0f;
            aspeed=0.0f;
            aspeedd=0.0f;
            sonlife=200;
            type=0.0f;
            longs=100f;
            wscale=1f;
            alpha=100f;
            Ray=false;
            sonspeed=5f;
            sonspeedd=0.0f;
            sonaspeed=0.0f;
            sonaspeedd=0.0f;
            xscale=1f;
            yscale=1f;
            Blend=false;
            Outdispel=true;
            Invincible=false;
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
                aspeedx=aspeed*(float)Math.cos(MathHelper.ToRadians(aspeedd));
                aspeedy=aspeed*(float)Math.sin(MathHelper.ToRadians(aspeedd));
                speedx=speed*(float)Math.cos(MathHelper.ToRadians(speedd));
                speedy=speed*(float)Math.sin(MathHelper.ToRadians(speedd));
                begin=(int)MathHelper.Clamp((float)begin,(float)Layer.LayerArray.get(parentid).begin,(float)(1+Layer.LayerArray.get(parentid).end-Layer.LayerArray.get(parentid).begin));
                life=(int)MathHelper.Clamp((float)life,1f,(float)(Layer.LayerArray.get(parentid).end-Layer.LayerArray.get(parentid).begin+2-begin));
            }
            if((double)type-1.0>=(double)Main.bgset.size())
                type=0.0f;
            if(bindid!=-1&&bindid>=Layer.LayerArray.get(parentid).BatchArray.size()) {
                bindid=-1;
                Deepbind=false;
                Bindwithspeedd=false;
            }
            if(!(Time.Playing&type!=-1.0))
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
                conditions[1]=r;
                conditions[2]=rdirection;
                conditions[3]=tiao;
                conditions[4]=t;
                conditions[5]=fdirection;
                conditions[6]=range;
                conditions[7]=wscale;
                conditions[8]=longs;
                conditions[9]=alpha;
                results[0]=r;
                results[1]=rdirection;
                results[2]=tiao;
                results[3]=t;
                results[4]=fdirection;
                results[5]=range;
                results[6]=speed;
                results[7]=speedd;
                results[8]=aspeed;
                results[9]=aspeedd;
                results[10]=life;
                results[11]=type;
                results[12]=wscale;
                results[13]=longs;
                results[14]=alpha;
                results[15]=sonspeed;
                results[16]=sonspeedd;
                results[17]=sonaspeed;
                results[18]=sonaspeedd;
                results[19]=xscale;
                results[20]=yscale;
                results[21]=0.0f;
                results[22]=0.0f;
                results[23]=0.0f;
                for(Event parentevent : Parentevents) {
                    if(parentevent.t<=0)
                        parentevent.t=1;
                    if(time%parentevent.t==0)
                        ++parentevent.loop;
                    for(EventRead result : parentevent.results) {
                        if(result.special==4) {
                            if(result.changevalue==1)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x-4f+Center.ox-Center.x,y+16f+Center.oy-Center.y));
                            if(result.changevalue==4)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x-4f+Center.ox-Center.x,y+16f+Center.oy-Center.y));
                            if(result.changevalue==18)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x-4f+Center.ox-Center.x,y+16f+Center.oy-Center.y));
                        }
                        if(result.opreator.equals(">")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    } else
                                        continue;
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    } else
                                        continue;
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    } else
                                        continue;
                                }
                            } else if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                LExecution lexecution = new LExecution();
                                if(!result.noloop) {
                                    if(result.time>0) {
                                        --result.time;
                                        if(result.time==0)
                                            result.noloop=true;
                                    }
                                    lexecution.parentid=parentid;
                                    lexecution.id=id;
                                    lexecution.change=result.change;
                                    lexecution.changetype=result.changetype;
                                    lexecution.changevalue=result.changevalue;
                                    lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                    lexecution.region=results[result.changename]+"";
                                    lexecution.time=result.times;
                                    lexecution.ctime=lexecution.time;
                                    Eventsexe.add(lexecution);
                                } else
                                    continue;
                            }
                        }
                        if(result.opreator.equals("=")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    } else
                                        continue;
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    } else
                                        continue;
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        } else
                                            continue;
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    } else
                                        continue;
                                }
                            } else if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                LExecution lexecution = new LExecution();
                                if(!result.noloop) {
                                    if(result.time>0) {
                                        --result.time;
                                        if(result.time==0)
                                            result.noloop=true;
                                    }
                                    lexecution.parentid=parentid;
                                    lexecution.id=id;
                                    lexecution.change=result.change;
                                    lexecution.changetype=result.changetype;
                                    lexecution.changevalue=result.changevalue;
                                    lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                    lexecution.region=results[result.changename]+"";
                                    lexecution.time=result.times;
                                    lexecution.ctime=lexecution.time;
                                    Eventsexe.add(lexecution);
                                } else
                                    continue;
                            }
                        }
                        if(result.opreator.equals("<")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        }
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    }
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        }
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    }
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        LExecution lexecution = new LExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            lexecution.parentid=parentid;
                                            lexecution.id=id;
                                            lexecution.change=result.change;
                                            lexecution.changetype=result.changetype;
                                            lexecution.changevalue=result.changevalue;
                                            lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            lexecution.region=results[result.changename]+"";
                                            lexecution.time=result.times;
                                            lexecution.ctime=lexecution.time;
                                            Eventsexe.add(lexecution);
                                        }
                                    }
                                } else if(result.collector.equals("或")&&((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime))) {
                                    LExecution lexecution = new LExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        lexecution.parentid=parentid;
                                        lexecution.id=id;
                                        lexecution.change=result.change;
                                        lexecution.changetype=result.changetype;
                                        lexecution.changevalue=result.changevalue;
                                        lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        lexecution.region=results[result.changename]+"";
                                        lexecution.time=result.times;
                                        lexecution.ctime=lexecution.time;
                                        Eventsexe.add(lexecution);
                                    }
                                }
                            } else if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                LExecution lexecution = new LExecution();
                                if(!result.noloop) {
                                    if(result.time>0) {
                                        --result.time;
                                        if(result.time==0)
                                            result.noloop=true;
                                    }
                                    lexecution.parentid=parentid;
                                    lexecution.id=id;
                                    lexecution.change=result.change;
                                    lexecution.changetype=result.changetype;
                                    lexecution.changevalue=result.changevalue;
                                    lexecution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                    lexecution.region=results[result.changename]+"";
                                    lexecution.time=result.times;
                                    lexecution.ctime=lexecution.time;
                                    Eventsexe.add(lexecution);
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
            if(t<=0)
                return;
            if(Deepbind) {
                Shoot();
            } else {
                if(time%t+(int)MathHelper.Lerp((float)-rand.t,(float)rand.t,(float)Main.rand.nextDouble())!=0)
                    return;
                Shoot();
            }
        }

        private void Shoot() {
            int num1 = tiao+(int)MathHelper.Lerp((float)-rand.tiao,(float)rand.tiao,(float)Main.rand.nextDouble());
            int num2 = (int)MathHelper.Lerp(-rand.r,rand.r,(float)Main.rand.nextDouble());
            float num3 = MathHelper.Lerp(-rand.rdirection,rand.rdirection,(float)Main.rand.nextDouble());
            int num4 = (int)MathHelper.Lerp((float)-rand.range,(float)rand.range,(float)Main.rand.nextDouble());
            float num5 = MathHelper.Lerp(-rand.sonspeed,rand.sonspeed,(float)Main.rand.nextDouble());
            float num6 = MathHelper.Lerp(-rand.fdirection,rand.fdirection,(float)Main.rand.nextDouble());
            float num7 = MathHelper.Lerp(-rand.sonaspeed,rand.sonaspeed,(float)Main.rand.nextDouble());
            float num8 = MathHelper.Lerp(-rand.sonaspeedd,rand.sonaspeedd,(float)Main.rand.nextDouble());
            if(bindid==-1) {
                for(int index1 = 0;index1<num1;++index1) {
                    Barrage barrage = new Barrage();
                    barrage.IsLase=true;
                    if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).rdirection==-99999.0)
                        rdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x-4f,y+16f));
                    float degrees = rdirection+((float)index1-(float)(((double)num1-1.0)/2.0))*(float)(range+num4)/(float)num1+num3;
                    barrage.x=(float)((double)x-4.0+((double)r+(double)num2)*Math.cos(MathHelper.ToRadians(degrees)))+Center.ox-Center.x;
                    barrage.y=(float)((double)y+16.0+((double)r+(double)num2)*Math.sin(MathHelper.ToRadians(degrees)))+Center.oy-Center.y;
                    barrage.life=sonlife;
                    barrage.type=(int)type;
                    barrage.wscale=wscale;
                    barrage.longs=longs;
                    barrage.alpha=alpha;
                    barrage.speed=sonspeed+num5;
                    if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).fdirection==-99999.0)
                        fdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,barrage.x,barrage.y));
                    else if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).fdirection==-100000.0)
                        fdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(fdirections.x,fdirections.y,barrage.x,barrage.y));
                    barrage.speedd=(float)((double)fdirection+(double)num6+(double)((float)index1-(float)(((double)num1-1.0)/2.0))*(double)(range+num4)/(double)num1);
                    barrage.aspeed=sonaspeed+num7;
                    if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).sonaspeedd==-99999.0)
                        Layer.LayerArray.get(parentid).LaseArray.get(id).copys.sonaspeedd=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,barrage.x,barrage.y));
                    else if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).sonaspeedd==-100000.0)
                        Layer.LayerArray.get(parentid).LaseArray.get(id).copys.sonaspeedd=(float) MathHelper.ToDegrees(Main.Twopointangle(sonaspeedds.x,sonaspeedds.y,barrage.x,barrage.y));
                    barrage.aspeedd=sonaspeedd+num8;
                    barrage.speedx=xscale*barrage.speed*(float)Math.cos(MathHelper.ToRadians(barrage.speedd));
                    barrage.speedy=yscale*barrage.speed*(float)Math.sin(MathHelper.ToRadians(barrage.speedd));
                    barrage.aspeedx=xscale*barrage.aspeed*(float)Math.cos(MathHelper.ToRadians(barrage.aspeedd));
                    barrage.aspeedy=yscale*barrage.aspeed*(float)Math.sin(MathHelper.ToRadians(barrage.aspeedd));
                    barrage.IsRay=Ray;
                    barrage.xscale=xscale;
                    barrage.yscale=yscale;
                    barrage.Blend=Blend;
                    barrage.Outdispel=Outdispel;
                    barrage.Invincible=Invincible;
                    for(int idx = 0;idx<Sonevents.size();++idx) {
                        Event _event = new Event(idx);
                        _event.t=Sonevents.get(idx).t;
                        _event.addtime=Sonevents.get(idx).addtime;
                        _event.events=Sonevents.get(idx).events;
                        for(int index2 = 0;index2<Sonevents.get(idx).results.size();++index2)
                            _event.results.add(Sonevents.get(idx).results.get(index2).Copy());
                        _event.index=Sonevents.get(idx).index;
                        barrage.Events.add(_event);
                    }
                    barrage.parentid=id;
                    Layer.LayerArray.get(parentid).Barrages.add(barrage);
                }
            } else {
                for(int index1 = 0;index1<Layer.LayerArray.get(parentid).Barrages.size();++index1) {
                    if(((!Layer.LayerArray.get(parentid).Barrages.get(index1).IsLase&Layer.LayerArray.get(parentid).Barrages.get(index1).parentid==bindid ? 1 : 0)&(Layer.LayerArray.get(parentid).Barrages.get(index1).time>15 ? 1 : (!Layer.LayerArray.get(parentid).Barrages.get(index1).Mist ? 1 : 0))&(!Layer.LayerArray.get(parentid).Barrages.get(index1).NeedDelete ? 1 : 0))!=0) {
                        if(Deepbind) {
                            if(Layer.LayerArray.get(parentid).Barrages.get(index1).lase!=null) {
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase.x=Layer.LayerArray.get(parentid).Barrages.get(index1).x;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase.y=Layer.LayerArray.get(parentid).Barrages.get(index1).y;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase.Update();
                            } else {
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase=BindClone();
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase.Deepbind=false;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase.Deepbinded=true;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase.bindid=-1;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase.time=0;
                                if(Bindwithspeedd)
                                    Layer.LayerArray.get(parentid).Barrages.get(index1).lase.fdirection+=Layer.LayerArray.get(parentid).Barrages.get(index1).fdirection;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).lase.Bindwithspeedd=false;
                            }
                        } else {
                            for(int index2 = 0;index2<num1;++index2) {
                                Barrage barrage = new Barrage();
                                barrage.IsLase=true;
                                if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).rdirection==-99999.0)
                                    rdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,Layer.LayerArray.get(parentid).Barrages.get(index1).x,Layer.LayerArray.get(parentid).Barrages.get(index1).y));
                                float degrees = rdirection+((float)index2-(float)(((double)num1-1.0)/2.0))*(float)(range+num4)/(float)num1+num3;
                                barrage.x=Layer.LayerArray.get(parentid).Barrages.get(index1).x+(r+(float)num2)*(float)Math.cos(MathHelper.ToRadians(degrees));
                                barrage.y=Layer.LayerArray.get(parentid).Barrages.get(index1).y+(r+(float)num2)*(float)Math.sin(MathHelper.ToRadians(degrees));
                                barrage.life=sonlife;
                                barrage.type=(int)type;
                                barrage.wscale=wscale;
                                barrage.longs=longs;
                                barrage.alpha=alpha;
                                barrage.speed=sonspeed+num5;
                                if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).fdirection==-99999.0)
                                    fdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,barrage.x,barrage.y));
                                else if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).fdirection==-100000.0)
                                    fdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(fdirections.x,fdirections.y,barrage.x,barrage.y));
                                barrage.speedd=!Bindwithspeedd ? (float)((double)fdirection+(double)num6+(double)((float)index2-(float)(((double)num1-1.0)/2.0))*(double)(range+num4)/(double)num1) : (float)((double)fdirection+(double)num6+(double)((float)index2-(float)(((double)num1-1.0)/2.0))*(double)(range+num4)/(double)num1)+Layer.LayerArray.get(parentid).Barrages.get(index1).speedd;
                                barrage.aspeed=sonaspeed+num7;
                                if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).sonaspeedd==-99999.0)
                                    sonaspeedd=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,barrage.x,barrage.y));
                                else if((double)Layer.LayerArray.get(parentid).LaseArray.get(id).sonaspeedd==-100000.0)
                                    sonaspeedd=(float) MathHelper.ToDegrees(Main.Twopointangle(sonaspeedds.x,sonaspeedds.y,barrage.x,barrage.y));
                                barrage.aspeedd=sonaspeedd+num8;
                                barrage.speedx=xscale*barrage.speed*(float)Math.cos(MathHelper.ToRadians(barrage.speedd));
                                barrage.speedy=yscale*barrage.speed*(float)Math.sin(MathHelper.ToRadians(barrage.speedd));
                                barrage.aspeedx=xscale*barrage.aspeed*(float)Math.cos(MathHelper.ToRadians(barrage.aspeedd));
                                barrage.aspeedy=yscale*barrage.aspeed*(float)Math.sin(MathHelper.ToRadians(barrage.aspeedd));
                                barrage.IsRay=Ray;
                                barrage.xscale=xscale;
                                barrage.yscale=yscale;
                                barrage.Blend=Blend;
                                barrage.Outdispel=Outdispel;
                                barrage.Invincible=Invincible;
                                for(int idx = 0;idx<Sonevents.size();++idx) {
                                    Event _event = new Event(idx);
                                    _event.t=Sonevents.get(idx).t;
                                    _event.addtime=Sonevents.get(idx).addtime;
                                    _event.events=Sonevents.get(idx).events;
                                    for(int index3 = 0;index3<Sonevents.get(idx).results.size();++index3)
                                        _event.results.add(Sonevents.get(idx).results.get(index3).Copy());
                                    _event.index=Sonevents.get(idx).index;
                                    barrage.Events.add(_event);
                                }
                                barrage.parentid=id;
                                Layer.LayerArray.get(parentid).Barrages.add(barrage);
                            }
                        }
                    }
                }
            }
        }

        public Lase BindClone() {
            Lase lase = Copy() as Lase;
            lase.Parentevents=new ArrayList<Event>();
            for(Event parentevent : Parentevents)
                lase.Parentevents.add((Event)parentevent.Clone());
            lase.Eventsexe=new ArrayList<LExecution>();
            for(LExecution lexecution : Eventsexe)
                lase.Eventsexe.add((LExecution)lexecution.Clone());
            lase.Sonevents=new ArrayList<Event>();
            for(Event sonevent : Sonevents)
                lase.Sonevents.add((Event)sonevent.Clone());
            return lase;
        }

        public object Clone() {
            MemoryStream memoryStream = new MemoryStream();
            BinaryFormatter binaryFormatter = new BinaryFormatter();
            binaryFormatter.Serialize((Stream)memoryStream,(object)this);
            memoryStream.Seek(0L,SeekOrigin.Begin);
            object obj = binaryFormatter.Deserialize((Stream)memoryStream);
            memoryStream.Close();
            return obj;
        }

        public object Copy() {
            return MemberwiseClone();
        }

        public void PreviewUpdate() {
            if(!(Time.now>=begin&Time.now<=begin+life-1))
                return;
            int now = Time.now;
            speedx+=aspeedx;
            speedy+=aspeedy;
            x+=speedx;
            y+=speedy;
        }
    }
