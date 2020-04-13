package runner;

import com.badlogic.gdx.math.*;
import java.util.*;
import runner.*;
import runner.layer.*;

public class Barrage {
        public int id = -1;
        public int parentid = -2;
        public Shadows[] savesha = new Shadows[50];
        public ArrayList<Integer> Covered = new ArrayList<>();
        public float dscale = 0.9f;
        private float[] conditions = new float[3];
        private float[] results = new float[21];
        public boolean IsLase;
        public boolean IsRay;
        public int shatime;
        public boolean NeedDelete;
        public boolean Dis;
        public int life;
        public int time;
        public int type;
        public float x;
        public float y;
        public float wscale;
        public float rwscale;
        public float hscale;
        public float longs;
        public float rlongs;
        public float randf;
        public float R;
        public float G;
        public float B;
        public float alpha;
        public float head;
        public float speed;
        public float speedx;
        public float speedy;
        public float bspeedx;
        public float bspeedy;
        public float speedd;
        public float vf;
        public float aspeed;
        public float aspeedx;
        public float aspeedy;
        public float aspeedd;
        public boolean Withspeedd;
        public float fdirection;
        public float sonaspeedd;
        public float fx;
        public float fy;
        public Vector2 fdirections;
        public Vector2 sonaspeedds;
        public float randfdirection;
        public float randsonaspeedd;
        public int g;
        public int tiaos;
        public int range;
        public int randrange;
        public float bindspeedd;
        public boolean Bindwithspeedd;
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
        public boolean Alreadylong;
        public int reboundtime;
        public int fadeout;
        public Batch batch;
        public Lase lase;
        public Cover cover;
        public ArrayList<Event> Events;
        public ArrayList<BExecution> Eventsexe;
        public ArrayList<BLExecution> LEventsexe;

        public Barrage() {
            NeedDelete=false;
            for(int index = 0;index<50;++index) {
                savesha[index]=new Shadows(x,y,0);
            }
            Events=new ArrayList<Event>();
            Eventsexe=new ArrayList<BExecution>();
            LEventsexe=new ArrayList<BLExecution>();
        }

        public void Update() {
            if(!IsLase&type!=-2) {
                float x1 = x;
                float y1 = y;
                float x2 = Player.position.x;
                float y2 = Player.position.y;
                int num1 = 0;
                if(Mist) {
                    num1=15;
                }
                ++time;
                if(type<=-1) {
                    type=-1;
                }
                if(type>=Main.bgset.size()) {
                    type=Main.bgset.size()-1;
                }
                if(time>15||!Mist) {
                    if(Mist&time==16||!Mist&time==1) {
                        if(fdirection==-99998.0) {
                            fdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(fx,fy,x,y));
                        } else if(fdirection==-99999.0) {
                            fdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                        } else if(this.fdirection==-100000.0) {
                            fdirection=(float) MathHelper.ToDegrees(Main.Twopointangle(fdirections.x,fdirections.y,x,y));
                        }
                        speedd=!Bindwithspeedd ? (float)(fdirection+(double)randfdirection+(g-(float)((tiaos-1.0)/2.0))*(double)(range+randrange)/tiaos) : (float)(fdirection+(double)randfdirection+(g-(float)((tiaos-1.0)/2.0))*(double)(range+randrange)/tiaos)+bindspeedd;
                        if(sonaspeedd==-99998.0) {
                            sonaspeedd=(float) MathHelper.ToDegrees(Main.Twopointangle(fx,fy,x,y));
                        } else if(sonaspeedd==-99999.0) {
                            sonaspeedd=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                        } else if(sonaspeedd==-100000.0) {
                            sonaspeedd=(float) MathHelper.ToDegrees(Main.Twopointangle(sonaspeedds.x,sonaspeedds.y,x,y));
                        }
                        aspeedd=sonaspeedd+randsonaspeedd;
                        speedx=xscale*speed*(float)Math.cos(MathHelper.ToRadians(speedd));
                        speedy=yscale*speed*(float)Math.sin(MathHelper.ToRadians(speedd));
                        aspeedx=xscale*aspeed*(float)Math.cos(MathHelper.ToRadians(aspeedd));
                        aspeedy=yscale*aspeed*(float)Math.sin(MathHelper.ToRadians(aspeedd));
                        if(Withspeedd) {
                            head=speedd+90f;
                        }
                    }
                    if(!Dis) {
                        speedx+=aspeedx*Time.stop;
                        speedy+=aspeedy*Time.stop;
                        x+=speedx*Time.stop;
                        y+=speedy*Time.stop;
                    }
                    if(speed!=0.0) {
                        if(speedy!=0.0) {
                            vf=1.570796f-(float)Math.atan((speedx/xscale)/(speedy/yscale));
                            if(speedy<0.0) {
                                vf+=3.141593f;
                            }
                        } else {
                            if(speedx>=0.0) {
                                vf=0.0f;
                            }
                            if(speedx<0.0) {
                                vf=3.141593f;
                            }
                        }
                        if(speed>0.0) {
                            speedd=(float) MathHelper.ToDegrees(vf);
                            if(Withspeedd) {
                                head=speedd;
                            }
                        } else if(Withspeedd) {
                            head=(float) MathHelper.ToDegrees(vf);
                        }
                    }
                    if(Afterimage&time<=num1+life) {
                        savesha[shatime].alpha=(float)(0.400000005960464*(alpha/100.0));
                        savesha[shatime].x=x;
                        savesha[shatime].y=y;
                        savesha[shatime].d=head;
                        ++shatime;
                        if(shatime>=49) {
                            shatime=0;
                        }
                    } else {
                        shatime=0;
                    }
                    conditions[0]=time-num1;
                    conditions[1]=x;
                    conditions[2]=y;
                    results[0]=life;
                    results[1]=type;
                    results[2]=wscale;
                    results[3]=hscale;
                    results[4]=R;
                    results[5]=G;
                    results[6]=B;
                    results[7]=alpha;
                    results[8]=head;
                    results[9]=speed;
                    results[10]=speedd;
                    results[11]=aspeed;
                    results[12]=aspeedd;
                    results[13]=xscale;
                    results[14]=yscale;
                    results[15]=0.0f;
                    results[16]=0.0f;
                    results[17]=0.0f;
                    results[18]=0.0f;
                    results[19]=0.0f;
                    results[20]=0.0f;
                    for(Event _event : Events) {
                        if(_event.t<=0) {
                            _event.t=1;
                        }
                        if((time-num1)%_event.t==0) {
                            ++_event.loop;
                        }
                        for(EventRead result : _event.results) {
                            if(result.special2==1) {
                                conditions[0]=Time.now;
                            }
                            if(result.opreator.equals(">")) {
                                if(result.opreator2.equals(">")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("=")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]>(double)Float.parseFloat(result.condition)+_event.loop*_event.addtime&conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+_event.loop*_event.addtime) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]>(double)Float.parseFloat(result.condition)+_event.loop*_event.addtime||conditions[result.contype2]==(double)Float.parseFloat(result.condition2)+_event.loop*_event.addtime)) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("<")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)) {
                                    if(result.special==4) {
                                        if(result.changevalue==10) {
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        if(result.changevalue==12) {
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                    }
                                    BExecution bexecution = new BExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        bexecution.change=result.change;
                                        bexecution.changetype=result.changetype;
                                        bexecution.changevalue=result.changevalue;
                                        bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        bexecution.region=results[result.changename]+"";
                                        bexecution.time=result.times;
                                        bexecution.ctime=bexecution.time;
                                        Eventsexe.add(bexecution);
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if(result.opreator.equals("=")) {
                                if(result.opreator2.equals(">")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("=")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("<")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)) {
                                    if(result.special==4) {
                                        if(result.changevalue==10) {
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        if(result.changevalue==12) {
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                    }
                                    BExecution bexecution = new BExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        bexecution.change=result.change;
                                        bexecution.changetype=result.changetype;
                                        bexecution.changevalue=result.changevalue;
                                        bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        bexecution.region=results[result.changename]+"";
                                        bexecution.time=result.times;
                                        bexecution.ctime=bexecution.time;
                                        Eventsexe.add(bexecution);
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if(result.opreator.equals("<")) {
                                if(result.opreator2.equals(">")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("=")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]<(double)Float.parseFloat(result.condition)+_event.loop*_event.addtime&conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("<")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==10) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                                if(result.changevalue==12) {
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                }
                                            }
                                            BExecution bexecution = new BExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                bexecution.change=result.change;
                                                bexecution.changetype=result.changetype;
                                                bexecution.changevalue=result.changevalue;
                                                bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                bexecution.region=results[result.changename]+"";
                                                bexecution.time=result.times;
                                                bexecution.ctime=bexecution.time;
                                                Eventsexe.add(bexecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==10) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            if(result.changevalue==12) {
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                        }
                                        BExecution bexecution = new BExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            bexecution.change=result.change;
                                            bexecution.changetype=result.changetype;
                                            bexecution.changevalue=result.changevalue;
                                            bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            bexecution.region=results[result.changename]+"";
                                            bexecution.time=result.times;
                                            bexecution.ctime=bexecution.time;
                                            Eventsexe.add(bexecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)) {
                                    if(result.special==4) {
                                        if(result.changevalue==10) {
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        if(result.changevalue==12) {
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                    }
                                    BExecution bexecution = new BExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        bexecution.change=result.change;
                                        bexecution.changetype=result.changetype;
                                        bexecution.changevalue=result.changevalue;
                                        bexecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        bexecution.region=results[result.changename]+"";
                                        bexecution.time=result.times;
                                        bexecution.ctime=bexecution.time;
                                        Eventsexe.add(bexecution);
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if(result.special==5) {
                                x=Center.ox;
                                y=Center.oy;
                            }
                            if(result.special2==1) {
                                conditions[0]=Time.now;
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
                     if(time>num1+life) {
                        NeedDelete = true;
                        if (Dispel&type>=0) {
                        } else {
                            NeedDelete=true;
                        }
                    }
                } else if(!Invincible&&Math.sqrt((x-(double)Player.position.x)*(x-(double)Player.position.x)+(y-(double)Player.position.y)*(y-(double)Player.position.y))<=10.0) {
                    NeedDelete=true;
                }
                int num2 = 0;
                for(Shadows shadows : savesha) {
                    if(shadows.alpha<=0.0)
                        ++num2;
                }
                if(Outdispel) {
                    if(num2==savesha.length) {
                        if(x<0||x>630||(y<0||y>480)) {
                            NeedDelete=true;
                        }
                    }
                } else if(num2==savesha.length) {
                    if(x<-110.0||x>740.0||(y<-250.0||y>730.0)) {
                        NeedDelete=true;
                    }
                }
            }
            if(!(!IsLase&type==-2)) {
                return;
            }
            NeedDelete=true;
        } 

        public void LUpdate() {
            if(IsLase&type!=-1) {
                float x1 = x;
                float y1 = y;
                float x2 = Player.position.x;
                float y2 = Player.position.y;
                ++time;
                if(time<=life) {
                    conditions[0]=time;
                    results[0]=life;
                    results[1]=type;
                    results[2]=wscale;
                    results[3]=longs;
                    results[4]=alpha;
                    results[5]=speed;
                    results[6]=speedd;
                    results[7]=aspeed;
                    results[8]=aspeedd;
                    results[9]=xscale;
                    results[10]=yscale;
                    results[11]=0.0f;
                    results[12]=0.0f;
                    results[13]=0.0f;
                    for(Event _event : Events) {
                        if(_event.t<=0)
                            _event.t=1;
                        if(time%_event.t==0)
                            ++_event.loop;
                        for(EventRead result : _event.results) {
                            if(result.opreator.equals(">")) {
                                if(result.opreator2.equals(">")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("=")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("<")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(conditions[result.contype]>Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)) {
                                    if(result.special==4) {
                                        if(result.changevalue==6)
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        if(result.changevalue==8)
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                    }
                                    BLExecution blExecution = new BLExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        blExecution.change=result.change;
                                        blExecution.changetype=result.changetype;
                                        blExecution.changevalue=result.changevalue;
                                        blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        blExecution.region=results[result.changename]+"";
                                        blExecution.time=result.times;
                                        blExecution.ctime=blExecution.time;
                                        LEventsexe.add(blExecution);
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if(result.opreator.equals("=")) {
                                if(result.opreator2.equals(">")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("=")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("<")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(conditions[result.contype]==Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)) {
                                    if(result.special==4) {
                                        if(result.changevalue==6)
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        if(result.changevalue==8)
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                    }
                                    BLExecution blExecution = new BLExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        blExecution.change=result.change;
                                        blExecution.changetype=result.changetype;
                                        blExecution.changevalue=result.changevalue;
                                        blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        blExecution.region=results[result.changename]+"";
                                        blExecution.time=result.times;
                                        blExecution.ctime=blExecution.time;
                                        LEventsexe.add(blExecution);
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if(result.opreator.equals("<")) {
                                if(result.opreator2.equals(">")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]<(double)Float.parseFloat(result.condition)+_event.loop*_event.addtime&conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]>Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("=")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]==Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(result.opreator2.equals("<")) {
                                    if(result.collector.equals("且")) {
                                        if(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)&conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime)) {
                                            if(result.special==4) {
                                                if(result.changevalue==6)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                                if(result.changevalue==8)
                                                    result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            }
                                            BLExecution blExecution = new BLExecution();
                                            if(!result.noloop) {
                                                if(result.time>0) {
                                                    --result.time;
                                                    if(result.time==0)
                                                        result.noloop=true;
                                                }
                                                blExecution.change=result.change;
                                                blExecution.changetype=result.changetype;
                                                blExecution.changevalue=result.changevalue;
                                                blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                                blExecution.region=results[result.changename]+"";
                                                blExecution.time=result.times;
                                                blExecution.ctime=blExecution.time;
                                                LEventsexe.add(blExecution);
                                            } else {
                                                continue;
                                            }
                                        }
                                    } else if(result.collector.equals("或")&&(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)||conditions[result.contype2]<Float.parseFloat(result.condition2)+(double)(_event.loop*_event.addtime))) {
                                        if(result.special==4) {
                                            if(result.changevalue==6)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                            if(result.changevalue==8)
                                                result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        }
                                        BLExecution blExecution = new BLExecution();
                                        if(!result.noloop) {
                                            if(result.time>0) {
                                                --result.time;
                                                if(result.time==0)
                                                    result.noloop=true;
                                            }
                                            blExecution.change=result.change;
                                            blExecution.changetype=result.changetype;
                                            blExecution.changevalue=result.changevalue;
                                            blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                            blExecution.region=results[result.changename]+"";
                                            blExecution.time=result.times;
                                            blExecution.ctime=blExecution.time;
                                            LEventsexe.add(blExecution);
                                        } else {
                                            continue;
                                        }
                                    }
                                } else if(conditions[result.contype]<Float.parseFloat(result.condition)+(double)(_event.loop*_event.addtime)) {
                                    if(result.special==4) {
                                        if(result.changevalue==6)
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                        if(result.changevalue==8)
                                            result.res=(float) MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,x,y));
                                    }
                                    BLExecution blExecution = new BLExecution();
                                    if(!result.noloop) {
                                        if(result.time>0) {
                                            --result.time;
                                            if(result.time==0)
                                                result.noloop=true;
                                        }
                                        blExecution.change=result.change;
                                        blExecution.changetype=result.changetype;
                                        blExecution.changevalue=result.changevalue;
                                        blExecution.value=result.res+MathHelper.Lerp(-result.rand,result.rand,(float)Main.rand.nextDouble());
                                        blExecution.region=results[result.changename]+"";
                                        blExecution.time=result.times;
                                        blExecution.ctime=blExecution.time;
                                        LEventsexe.add(blExecution);
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            if(result.special==5) {
                                x=Center.ox;
                                y=Center.oy;
                            }
                        }
                    }
                    for(int index = 0;index<LEventsexe.size();++index) {
                        if(!LEventsexe.get(index).NeedDelete) {
                            LEventsexe.get(index).Update(this);
                        } else {
                            LEventsexe.remove(index);
                            --index;
                        }
                    }
                    rwscale=wscale;
                    if(!IsRay) {
                        if(speedy!=0.0) {
                            vf=1.570796f-(float)Math.atan(speedx/(double)speedy);
                            if(speedy<0.0) {
                                vf+=3.141593f;
                            }
                        } else {
                            if(speedx>=0.0) {
                                vf=0.0f;
                            }
                            if(speedx<0.0) {
                                vf=3.141593f;
                            }
                        }
                        head=(float) MathHelper.ToDegrees(vf);
                        if(rlongs<(double)longs&!Alreadylong) {
                            rlongs+=speed;
                        }
                        if(rlongs>=(double)longs) {
                            Alreadylong=true;
                        }
                        if(rlongs>=(double)longs||Alreadylong) {
                            rlongs=longs;
                            speedx+=aspeedx*Time.stop;
                            speedy+=aspeedy*Time.stop;
                            x+=speedx*Time.stop;
                            y+=speedy*Time.stop;
                            if(Outdispel) {
                                if(x<0||x>630||(y<0||y>480)) {
                                    NeedDelete=true;
                                }
                            } else if(x<-110.0||x>740.0||(y<-250.0||y>730.0)) {
                                NeedDelete=true;
                            }
                        }
                       } else {
                        rlongs=792f;
                        head=speedd;
                        speedx+=aspeedx*Time.stop;
                        speedy+=aspeedy*Time.stop;
                        x+=speedx*Time.stop;
                        y+=speedy*Time.stop;
                        }
                } else {
                    if(!IsRay) {
                        speedx+=aspeedx;
                        speedy+=aspeedy;
                        x+=speedx;
                        y+=speedy;
                        rlongs-=speed;
                        wscale-=0.1f*rwscale;
                        if(wscale<0.0) {
                            wscale=0.0f;
                        }
                        if(rlongs<0.0) {
                            rlongs=0.0f;
                        }
                        if(rlongs==0.0) {
                            NeedDelete=true;
                        }
                    } else {
                        head=speedd;
                        wscale-=0.1f*rwscale;
                        if(wscale<0.0) {
                            wscale=0.0f;
                        }
                        if(wscale==0.0) {
                            NeedDelete=true;
                        }
                    }
                    for(int index = 0;index<LEventsexe.size();++index) {
                        if(!LEventsexe.get(index).NeedDelete) {
                            LEventsexe.get(index).Update(this);
                        } else {
                            LEventsexe.remove(index);
                            --index;
                        }
                    }
                }
            }
            if(!(IsLase&type==-1)) {
                return;
            }
            NeedDelete=true;
        } 
    }
