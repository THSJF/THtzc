package runner.layer;

import com.badlogic.gdx.math.*;
import com.meng.TaiHunDanmaku.*;
import java.util.*;
import runner.*;

public class Batch implements Cloneable{
        public int bindid = -1;
        private float[] conditions = new float[13];
        private float[] results = new float[33];
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
        public float fx;
        public float fy;
        public float r;
        public float rdirection;
        public Vector2 rdirections;
        public int tiao;
        public int t;
        public float fdirection;
        public float bfdirection;
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
        public float wscale;
        public float hscale;
        public float colorR;
        public float colorG;
        public float colorB;
        public float alpha;
        public float head;
        public Vector2 heads;
        public boolean Withspeedd;
        public float sonspeed;
        public float sonspeedd;
        public Vector2 sonspeedds;
        public float sonaspeed;
        public float sonaspeedd;
        public float bsonaspeedd;
        public Vector2 sonaspeedds;
        public float xscale;
        public float yscale;
        public boolean Mist;
        public boolean Dispel;
        public boolean Blend;
        public boolean Afterimage;
        public boolean Outdispel;
        public boolean Invincible;
        public boolean Cover;
        public boolean Rebound;
        public boolean Force;
        public Batch rand;
        public ArrayList<Event> Parentevents;
        public ArrayList<Execution> Eventsexe;
        public ArrayList<Event> Sonevents;
        public Batch copys;

        public Batch() {
        }

        public Batch(float xs,float ys,int pc) {
            rand=new Batch();
            rdirections=new Vector2();
            fdirections=new Vector2();
            speedds=new Vector2();
            aspeedds=new Vector2();
            heads=new Vector2();
            sonspeedds=new Vector2();
            sonaspeedds=new Vector2();
            Parentevents=new ArrayList<Event>();
            Sonevents=new ArrayList<Event>();
            Eventsexe=new ArrayList<Execution>();
            x=xs;
            y=ys;
            parentcolor=pc;
            begin=Layer.LayerArray.get(parentid).begin;
            life=Layer.LayerArray.get(parentid).end-Layer.LayerArray.get(parentid).begin+1;
            fx=-99998f;
            fy=-99998f;
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
            type=1f;
            wscale=1f;
            hscale=1f;
            colorR=Byte.MAX_VALUE;
            colorG=Byte.MAX_VALUE;
            colorB=Byte.MAX_VALUE;
            alpha=100f;
            head=0.0f;
            Withspeedd=true;
            sonspeed=5f;
            sonspeedd=0.0f;
            sonaspeed=0.0f;
            sonaspeedd=0.0f;
            xscale=1f;
            yscale=1f;
            Mist=true;
            Dispel=true;
            Blend=false;
            Afterimage=false;
            Outdispel=true;
            Invincible=false;
            Cover=true;
            Rebound=true;
            Force=true;
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
            if(bindid==id) {
                bindid=-1;
                Deepbind=false;
                Bindwithspeedd=false;
            }
            if(bindid!=-1&&bindid>=Layer.LayerArray.get(parentid).BatchArray.size()) {
                bindid=-1;
                Deepbind=false;
                Bindwithspeedd=false;
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
                fx+=speedx;
                fy+=speedy;
                conditions[0]=!Deepbinded ? (float)time : (float)(time-begin+1);
                conditions[1]=fx;
                conditions[2]=fy;
                conditions[3]=r;
                conditions[4]=rdirection;
                conditions[5]=tiao;
                conditions[6]=t;
                conditions[7]=fdirection;
                conditions[8]=range;
                conditions[9]=wscale;
                conditions[10]=hscale;
                conditions[11]=alpha;
                conditions[12]=head;
                results[0]=fx;
                results[1]=fy;
                results[2]=r;
                results[3]=rdirection;
                results[4]=tiao;
                results[5]=t;
                results[6]=fdirection;
                results[7]=range;
                results[8]=speed;
                results[9]=speedd;
                results[10]=aspeed;
                results[11]=aspeedd;
                results[12]=life;
                results[13]=type;
                results[14]=wscale;
                results[15]=hscale;
                results[16]=colorR;
                results[17]=colorG;
                results[18]=colorB;
                results[19]=alpha;
                results[20]=head;
                results[21]=sonspeed;
                results[22]=sonspeedd;
                results[23]=sonaspeed;
                results[24]=sonaspeedd;
                results[25]=xscale;
                results[26]=yscale;
                results[27]=0.0f;
                results[28]=0.0f;
                results[29]=0.0f;
                results[30]=0.0f;
                results[31]=0.0f;
                results[32]=0.0f;
                for(Event parentevent : Parentevents) {
                    if(parentevent.t<=0)
                        parentevent.t=1;
                    if(time%parentevent.t==0)
                        ++parentevent.loop;
                    for(EventRead result : parentevent.results) {
                        if(result.special==3) {
                            if(result.changevalue==0)
                                result.res=x-4f;
                            if(result.changevalue==1)
                                result.res=y+16f;
                            if(result.changevalue==6)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(x-4f,y+16f,fx,fy));
                            if(result.changevalue==24)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(x-4f,y+16f,fx,fy));
                        }
                        if(result.special==4) {
                            if(result.changevalue==0)
                                result.res=Player.position.x;
                            if(result.changevalue==1)
                                result.res=Player.position.y;
                            if(result.changevalue==3)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,fx,fy));
                            if(result.changevalue==6)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,fx,fy));
                            if(result.changevalue==9)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,fx,fy));
                            if(result.changevalue==11)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,fx,fy));
                            if(result.changevalue==24)
                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,fx,fy));
                        }
                        if(result.opreator.equals(">")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            } else
                                                continue;
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        } else
                                            continue;
                                    }
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            } else
                                                continue;
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        } else
                                            continue;
                                    }
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            } else
                                                continue;
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        } else
                                            continue;
                                    }
                                }
                            } else if((double)conditions[result.contype]>(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                if(result.special==1)
                                    Recover();
                                else if(result.special==2) {
                                    Shoot();
                                } else {
                                    Execution execution = new Execution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        execution.parentid=parentid;
                                        execution.id=id;
                                        execution.change=result.change;
                                        execution.changetype=result.changetype;
                                        execution.changevalue=result.changevalue;
                                        execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        execution.region=results[result.changename]+"";
                                        execution.time=result.times;
                                        execution.ctime=execution.time;
                                        Eventsexe.add(execution);
                                    } else
                                        continue;
                                }
                            }
                        }
                        if(result.opreator.equals("=")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            } else
                                                continue;
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        } else
                                            continue;
                                    }
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            } else
                                                continue;
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        } else
                                            continue;
                                    }
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            } else
                                                continue;
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        } else
                                            continue;
                                    }
                                }
                            } else if((double)conditions[result.contype]==(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                if(result.special==1)
                                    Recover();
                                else if(result.special==2) {
                                    Shoot();
                                } else {
                                    Execution execution = new Execution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        execution.parentid=parentid;
                                        execution.id=id;
                                        execution.change=result.change;
                                        execution.changetype=result.changetype;
                                        execution.changevalue=result.changevalue;
                                        execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        execution.region=results[result.changename]+"";
                                        execution.time=result.times;
                                        execution.ctime=execution.time;
                                        Eventsexe.add(execution);
                                    } else
                                        continue;
                                }
                            }
                        }
                        if(result.opreator.equals("<")){
                            if(result.opreator2.equals(">")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            }
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]>(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        }
                                    }
                                }
                            } else if(result.opreator2.equals("=")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            }
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        }
                                    }
                                }
                            } else if(result.opreator2.equals("<")){
                                if(result.collector.equals("且")){
                                    if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)&(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)) {
                                        if(result.special==1)
                                            Recover();
                                        else if(result.special==2) {
                                            Shoot();
                                        } else {
                                            Execution execution = new Execution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                execution.parentid=parentid;
                                                execution.id=id;
                                                execution.change=result.change;
                                                execution.changetype=result.changetype;
                                                execution.changevalue=result.changevalue;
                                                execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                execution.region=results[result.changename]+"";
                                                execution.time=result.times;
                                                execution.ctime=execution.time;
                                                Eventsexe.add(execution);
                                            }
                                        }
                                    }
                                } else if(result.collector.equals("或")&&(((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)||(double)conditions[result.contype2]<(double)Float.parseFloat(result.condition2)+(double)(parentevent.loop*parentevent.addtime)))) {
                                    if(result.special==1)
                                        Recover();
                                    else if(result.special==2) {
                                        Shoot();
                                    } else {
                                        Execution execution = new Execution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            execution.parentid=parentid;
                                            execution.id=id;
                                            execution.change=result.change;
                                            execution.changetype=result.changetype;
                                            execution.changevalue=result.changevalue;
                                            execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            execution.region=results[result.changename]+"";
                                            execution.time=result.times;
                                            execution.ctime=execution.time;
                                            Eventsexe.add(execution);
                                        }
                                    }
                                }
                            } else if((double)conditions[result.contype]<(double)Float.parseFloat(result.condition)+(double)(parentevent.loop*parentevent.addtime)) {
                                if(result.special==1)
                                    Recover();
                                else if(result.special==2) {
                                    Shoot();
                                } else {
                                    Execution execution = new Execution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        execution.parentid=parentid;
                                        execution.id=id;
                                        execution.change=result.change;
                                        execution.changetype=result.changetype;
                                        execution.changevalue=result.changevalue;
                                        execution.value=(double)result.rand==0.0 ? result.res : result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        execution.region=results[result.changename]+"";
                                        execution.time=result.times;
                                        execution.ctime=execution.time;
                                        Eventsexe.add(execution);
                                    }
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
            float num2 = (int)MathHelper.Lerp(-rand.fx,rand.fx,(float)Main.rand.nextDouble());
            float num3 = (int)MathHelper.Lerp(-rand.fy,rand.fy,(float)Main.rand.nextDouble());
            int num4 = (int)MathHelper.Lerp(-rand.r,rand.r,(float)Main.rand.nextDouble());
            float num5 = MathHelper.Lerp(-rand.rdirection,rand.rdirection,(float)Main.rand.nextDouble());
            float num6 = (int)MathHelper.Lerp(-rand.head,rand.head,(float)Main.rand.nextDouble());
            int num7 = (int)MathHelper.Lerp((float)-rand.range,(float)rand.range,(float)Main.rand.nextDouble());
            float num8 = MathHelper.Lerp(-rand.sonspeed,rand.sonspeed,(float)Main.rand.nextDouble());
            float num9 = MathHelper.Lerp(-rand.fdirection,rand.fdirection,(float)Main.rand.nextDouble());
            float num10 = MathHelper.Lerp(-rand.sonaspeed,rand.sonaspeed,(float)Main.rand.nextDouble());
            float num11 = MathHelper.Lerp(-rand.sonaspeedd,rand.sonaspeedd,(float)Main.rand.nextDouble());
            float val1 = MathHelper.Lerp(-rand.wscale,rand.wscale,(float)Main.rand.nextDouble());
            float val2 = MathHelper.Lerp(-rand.hscale,rand.hscale,(float)Main.rand.nextDouble());
            if(bindid==-1) {
                for(int index1 = 0;index1<num1;++index1) {
                    if(Layer.LayerArray.get(parentid).BatchArray.get(id).rdirection==-99999.0) {
                        rdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,fx,fy));
                    }
                    float degrees = rdirection+(index1-(float)((num1-1.0)/2.0))*(range+num7)/num1+num5;
                    Barrage barrage = new Barrage();
                        barrage.x=fx+(float)((r+(double)num4)*Math.cos(MathHelper.ToRadians(degrees)))+num2+Center.ox-Center.x;
					barrage.y=fy+(float)((r+(double)num4)*Math.sin(MathHelper.ToRadians(degrees)))+num3+Center.oy-Center.y;
					barrage.life=sonlife;
					barrage.type=(int)type-1;
					barrage.wscale=wscale+Math.max(val1,val2);
					barrage.hscale=hscale+Math.max(val1,val2);
					barrage.head=head+num6;
					barrage.alpha=alpha;
					barrage.R=colorR;
					barrage.G=colorG;
					barrage.B=colorB;
					barrage.speed=sonspeed+num8;
					barrage. aspeed=sonaspeed+num10;
					barrage.fx=x-4f;
					barrage.fy=y+16f;
					barrage.fdirection=(double)bfdirection<-99997.0 ? bfdirection : fdirection;
					barrage.fdirections=fdirections.cpy();
					barrage.randfdirection=num9;
					barrage.g=index1;
                    barrage.tiaos=num1;
					barrage.range=range;
					barrage.randrange=num7;
					barrage.sonaspeedd=(double)bsonaspeedd<-99997.0 ? bsonaspeedd : sonaspeedd;
					barrage.sonaspeedds=sonaspeedds.cpy();
                    barrage.randsonaspeedd=num11;
					barrage.Withspeedd=Withspeedd;
                    barrage.xscale=xscale;
					barrage.yscale=yscale;
                    barrage.Mist=Mist;
					barrage.Dispel=Dispel;
					barrage. Blend=Blend;
                    barrage.Outdispel=Outdispel;
                    barrage.Afterimage=Afterimage;
                    barrage.Invincible=Invincible;
					barrage.Cover=Cover;
                    barrage.Rebound=Rebound;
					barrage.Force=Force;
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
                            if(Layer.LayerArray.get(parentid).Barrages.get(index1).batch!=null) {
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.x=Layer.LayerArray.get(parentid).Barrages.get(index1).x;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.y=Layer.LayerArray.get(parentid).Barrages.get(index1).y;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.fx=Layer.LayerArray.get(parentid).Barrages.get(index1).x;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.fy=Layer.LayerArray.get(parentid).Barrages.get(index1).y;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.Update();
                            } else {
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch=BindClone();
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.Deepbind=false;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.Deepbinded=true;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.bindid=-1;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.time=0;
                                if(Bindwithspeedd)
                                    Layer.LayerArray.get(parentid).Barrages.get(index1).batch.fdirection+=Layer.LayerArray.get(parentid).Barrages.get(index1).fdirection;
                                Layer.LayerArray.get(parentid).Barrages.get(index1).batch.Bindwithspeedd=false;
                            }
                        } else {
                            for(int index2 = 0;index2<num1;++index2) {
                                Barrage barrage = new Barrage();
                                if((double)Layer.LayerArray.get(parentid).BatchArray.get(id).rdirection==-99999.0)
                                    rdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,Layer.LayerArray.get(parentid).Barrages.get(index1).x,Layer.LayerArray.get(parentid).Barrages.get(index1).y));
                                float degrees = rdirection+((float)index2-(float)(((double)num1-1.0)/2.0))*(float)(range+num7)/(float)num1+num5;
                                barrage.x=Layer.LayerArray.get(parentid).Barrages.get(index1).x+(float)(((double)r+(double)num4)*Math.cos((double)MathHelper.ToRadians(degrees)))+num2;
                                barrage.y=Layer.LayerArray.get(parentid).Barrages.get(index1).y+(float)(((double)r+(double)num4)*Math.sin((double)MathHelper.ToRadians(degrees)))+num3;
                                barrage.life=sonlife;
                                barrage.type=(int)type-1;
                                barrage.wscale=wscale+Math.max(val1,val2);
                                barrage.hscale=hscale+Math.max(val1,val2);
                                if((double)Layer.LayerArray.get(parentid).BatchArray.get(id).head==-100000.0)
                                    head=(float) MathHelper.ToDegrees(Main.Twopointangle(heads.x,heads.y,barrage.x,barrage.y));
                                barrage.head=head+num6;
                                barrage.alpha=alpha;
                                barrage.R=colorR;
                                barrage.G=colorG;
                                barrage.B=colorB;
                                barrage.speed=sonspeed+num8;
                                barrage.aspeed=sonaspeed+num10;
                                barrage.fx=x-4f;
                                barrage.fy=y+16f;
                                barrage.fdirection=(double)bfdirection<-99997.0 ? bfdirection : fdirection;
                                barrage.bindspeedd=Layer.LayerArray.get(parentid).Barrages.get(index1).speedd;
                                barrage.Bindwithspeedd=Bindwithspeedd;
                                barrage.fdirections=fdirections.cpy();
                                barrage.randfdirection=num9;
                                barrage.g=index2;
                                barrage.tiaos=num1;
                                barrage.range=range;
                                barrage.randrange=num7;
                                barrage.sonaspeedd=(double)bsonaspeedd<-99997.0 ? bsonaspeedd : sonaspeedd;
                                barrage.sonaspeedds=sonaspeedds.cpy();
                                barrage.randsonaspeedd=num11;
                                barrage.Withspeedd=Withspeedd;
                                barrage.xscale=xscale;
                                barrage.yscale=yscale;
                                barrage.Mist=Mist;
                                barrage.Dispel=Dispel;
                                barrage.Blend=Blend;
                                barrage.Outdispel=Outdispel;
                                barrage.Afterimage=Afterimage;
                                barrage.Invincible=Invincible;
                                barrage.Cover=Cover;
                                barrage.Rebound=Rebound;
                                barrage.Force=Force;
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
        public Batch BindClone() {
            Batch batch = Copy();
            batch.Parentevents=new ArrayList<Event>();
            for(Event parentevent : Parentevents)
                batch.Parentevents.add(parentevent.Clone());
            batch.Eventsexe=new ArrayList<Execution>();
            for(Execution execution : Eventsexe)
                batch.Eventsexe.add(execution.Clone());
            batch.Sonevents=new ArrayList<Event>();
            for(Event sonevent : Sonevents)
                batch.Sonevents.add(sonevent.Clone());
            return batch;
        }

        public Batch Clone() {
			try {
				Batch batch=(Batch)super.clone();
				batch.conditions=conditions.clone();
				batch.results=results.clone();
				batch.rdirections=rdirections.cpy();
				batch.fdirections=fdirections.cpy();
				batch.speedds=speedds.cpy();
				batch.aspeedds=aspeedds.cpy();
				batch.heads=heads.cpy();
				batch.sonspeedds=sonspeedds.cpy();
				batch.sonaspeedds=sonaspeedds.cpy();
				batch.rand=rand.Clone();
				batch.copys=copys.Clone();
				batch.Parentevents=new ArrayList<>();
				for(Event e:Parentevents){
					batch.Parentevents.add(e.Clone());
				}
				batch.Eventsexe =new ArrayList<>();
				for(Execution e:Eventsexe){
					batch.Eventsexe.add(e.Clone());
				}
				batch.Sonevents=new ArrayList<>();
				for(Event e:Sonevents){
					batch.Sonevents.add(e.Clone());
				}
				return batch;
			} catch (CloneNotSupportedException e) {
				return null;
			}
        }

        public Batch Copy() {
            try {
				return (Batch)super.clone();
			} catch (CloneNotSupportedException e) {
				return null;
			}
        }

        public void Recover() {
            x=Layer.LayerArray.get(parentid).BatchArray.get(id).x;
            y=Layer.LayerArray.get(parentid).BatchArray.get(id).y;
            parentcolor=Layer.LayerArray.get(parentid).BatchArray.get(id).parentcolor;
            begin=Layer.LayerArray.get(parentid).BatchArray.get(id).begin;
            life=Layer.LayerArray.get(parentid).BatchArray.get(id).life;
            fx=Layer.LayerArray.get(parentid).BatchArray.get(id).fx;
            fy=Layer.LayerArray.get(parentid).BatchArray.get(id).fy;
            r=Layer.LayerArray.get(parentid).BatchArray.get(id).r;
            rdirection=Layer.LayerArray.get(parentid).BatchArray.get(id).rdirection;
            tiao=Layer.LayerArray.get(parentid).BatchArray.get(id).tiao;
            t=Layer.LayerArray.get(parentid).BatchArray.get(id).t;
            fdirection=Layer.LayerArray.get(parentid).BatchArray.get(id).fdirection;
            range=Layer.LayerArray.get(parentid).BatchArray.get(id).range;
            speed=Layer.LayerArray.get(parentid).BatchArray.get(id).speed;
            speedd=Layer.LayerArray.get(parentid).BatchArray.get(id).speedd;
            aspeed=Layer.LayerArray.get(parentid).BatchArray.get(id).aspeed;
            aspeedd=Layer.LayerArray.get(parentid).BatchArray.get(id).aspeedd;
            sonlife=Layer.LayerArray.get(parentid).BatchArray.get(id).sonlife;
            type=Layer.LayerArray.get(parentid).BatchArray.get(id).type;
            wscale=Layer.LayerArray.get(parentid).BatchArray.get(id).wscale;
            hscale=Layer.LayerArray.get(parentid).BatchArray.get(id).hscale;
            colorR=Layer.LayerArray.get(parentid).BatchArray.get(id).colorR;
            colorG=Layer.LayerArray.get(parentid).BatchArray.get(id).colorG;
            colorB=Layer.LayerArray.get(parentid).BatchArray.get(id).colorB;
            alpha=Layer.LayerArray.get(parentid).BatchArray.get(id).alpha;
            head=Layer.LayerArray.get(parentid).BatchArray.get(id).head;
            Withspeedd=Layer.LayerArray.get(parentid).BatchArray.get(id).Withspeedd;
            sonspeed=Layer.LayerArray.get(parentid).BatchArray.get(id).sonspeed;
            sonspeedd=Layer.LayerArray.get(parentid).BatchArray.get(id).sonspeedd;
            sonaspeed=Layer.LayerArray.get(parentid).BatchArray.get(id).sonaspeed;
            sonaspeedd=Layer.LayerArray.get(parentid).BatchArray.get(id).sonaspeedd;
            xscale=Layer.LayerArray.get(parentid).BatchArray.get(id).xscale;
            yscale=Layer.LayerArray.get(parentid).BatchArray.get(id).yscale;
            Mist=Layer.LayerArray.get(parentid).BatchArray.get(id).Mist;
            Dispel=Layer.LayerArray.get(parentid).BatchArray.get(id).Dispel;
            Blend=Layer.LayerArray.get(parentid).BatchArray.get(id).Blend;
            Afterimage=Layer.LayerArray.get(parentid).BatchArray.get(id).Afterimage;
            Outdispel=Layer.LayerArray.get(parentid).BatchArray.get(id).Outdispel;
            Invincible=Layer.LayerArray.get(parentid).BatchArray.get(id).Invincible;
        }

        public void PreviewUpdate() {
            if(!(Time.now>=begin&Time.now<=begin+life-1))
                return;
            speedx+=aspeedx;
            speedy+=aspeedy;
            x+=speedx;
            y+=speedy;
            fx+=speedx;
            fy+=speedy;
        }
    }
