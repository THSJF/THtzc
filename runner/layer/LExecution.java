package runner.layer;
import runner.*;

public class LExecution implements Cloneable {
        public int parentid;
        public int id;
        public int change;
        public int changetype;
        public int changevalue;
        public String region;
        public float value;
        public int time;
        public int ctime;
        public boolean NeedDelete;

        public void Update(Lase objects) {
            if(changetype==0) {
                switch(changevalue) {
                    case 0:
                        if(change==0) {
                            objects.r=(objects.r*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.r+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.r-=value/(float)time;
                            break;
                        }
                        break;
                    case 1:
                        if(change==0) {
                            objects.rdirection=(objects.rdirection*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.rdirection+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.rdirection-=value/(float)time;
                            break;
                        }
                        break;
                    case 2:
                        if(change==0) {
                            objects.tiao=(int)(((double)objects.tiao*((double)ctime-1.0)+(double)value)/(double)ctime);
                            break;
                        }
                        if(change==1) {
                            objects.tiao+=(int)((double)value/(double)time);
                            break;
                        }
                        if(change==2) {
                            objects.tiao-=(int)((double)value/(double)time);
                            break;
                        }
                        break;
                    case 3:
                        if(change==0) {
                            objects.t=(int)(((double)objects.t*((double)ctime-1.0)+(double)value)/(double)ctime);
                            break;
                        }
                        if(change==1) {
                            objects.t+=(int)((double)value/(double)time);
                            break;
                        }
                        if(change==2) {
                            objects.t-=(int)((double)value/(double)time);
                            break;
                        }
                        break;
                    case 4:
                        if(change==0) {
                            objects.fdirection=(objects.fdirection*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.fdirection+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.fdirection-=value/(float)time;
                            break;
                        }
                        break;
                    case 5:
                        if(change==0) {
                            objects.range=(int)(((double)objects.range*((double)ctime-1.0)+(double)value)/(double)ctime);
                            break;
                        }
                        if(change==1) {
                            objects.range+=(int)((double)value/(double)time);
                            break;
                        }
                        if(change==2) {
                            objects.range-=(int)((double)value/(double)time);
                            break;
                        }
                        break;
                    case 6:
                        if(change==0)
                            objects.speed=(objects.speed*((float)ctime-1f)+value)/(float)ctime;
                        else if(change==1)
                            objects.speed+=value/(float)time;
                        else if(change==2)
                            objects.speed-=value/(float)time;
                        objects.speedx=objects.speed*(float)Math.cos(MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.speed*(float)Math.sin(MathHelper.ToRadians(objects.speedd));
                        break;
                    case 7:
                        if(change==0)
                            objects.speedd=(objects.speedd*((float)ctime-1f)+value)/(float)ctime;
                        else if(change==1)
                            objects.speedd+=value/(float)time;
                        else if(change==2)
                            objects.speedd-=value/(float)time;
                        objects.speedx=objects.speed*(float)Math.cos(MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.speed*(float)Math.sin(MathHelper.ToRadians(objects.speedd));
                        break;
                    case 8:
                        if(change==0)
                            objects.aspeed=(objects.aspeed*((float)ctime-1f)+value)/(float)ctime;
                        else if(change==1)
                            objects.aspeed+=value/(float)time;
                        else if(change==2)
                            objects.aspeed-=value/(float)time;
                        objects.aspeedx=objects.aspeed*(float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.aspeed*(float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 9:
                        if(change==0)
                            objects.aspeedd=(float)(int)(((double)objects.aspeedd*((double)ctime-1.0)+(double)value)/(double)ctime);
                        else if(change==1)
                            objects.aspeedd+=value/(float)time;
                        else if(change==2)
                            objects.aspeedd-=value/(float)time;
                        objects.aspeedx=objects.aspeed*(float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.aspeed*(float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 10:
                        if(change==0) {
                            objects.sonlife=(int)(((double)objects.sonlife*((double)ctime-1.0)+(double)value)/(double)ctime);
                            break;
                        }
                        if(change==1) {
                            objects.sonlife+=(int)((double)value/(double)time);
                            break;
                        }
                        if(change==2) {
                            objects.sonlife-=(int)((double)value/(double)time);
                            break;
                        }
                        break;
                    case 11:
                        if(change==0) {
                            objects.type=(objects.type*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.type+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.type-=value/(float)time;
                            break;
                        }
                        break;
                    case 12:
                        if(change==0) {
                            objects.wscale=(objects.wscale*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.wscale+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.wscale-=value/(float)time;
                            break;
                        }
                        break;
                    case 13:
                        if(change==0) {
                            objects.longs=(objects.longs*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.longs+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.longs-=value/(float)time;
                            break;
                        }
                        break;
                    case 14:
                        if(change==0) {
                            objects.alpha=(objects.alpha*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.alpha+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.alpha-=value/(float)time;
                            break;
                        }
                        break;
                    case 15:
                        if(change==0) {
                            objects.sonspeed=value;
                            break;
                        }
                        if(change==1) {
                            objects.sonspeed+=value;
                            break;
                        }
                        if(change==2) {
                            objects.sonspeed-=value;
                            break;
                        }
                        break;
                    case 16:
                        if(change==0) {
                            objects.sonspeedd=value;
                            break;
                        }
                        if(change==1) {
                            objects.sonspeedd+=value;
                            break;
                        }
                        if(change==2) {
                            objects.sonspeedd-=value;
                            break;
                        }
                        break;
                    case 17:
                        if(change==0) {
                            objects.sonaspeed=value;
                            break;
                        }
                        if(change==1) {
                            objects.sonaspeed+=value;
                            break;
                        }
                        if(change==2) {
                            objects.sonaspeed-=value;
                            break;
                        }
                        break;
                    case 18:
                        if(change==0) {
                            objects.sonaspeedd=value;
                            break;
                        }
                        if(change==1) {
                            objects.sonaspeedd+=value;
                            break;
                        }
                        if(change==2) {
                            objects.sonaspeedd-=value;
                            break;
                        }
                        break;
                    case 19:
                        if(change==0) {
                            objects.xscale=value;
                            break;
                        }
                        if(change==1) {
                            objects.xscale+=value;
                            break;
                        }
                        if(change==2) {
                            objects.xscale-=value;
                            break;
                        }
                        break;
                    case 20:
                        if(change==0) {
                            objects.yscale=value;
                            break;
                        }
                        if(change==1) {
                            objects.yscale+=value;
                            break;
                        }
                        if(change==2) {
                            objects.yscale-=value;
                            break;
                        }
                        break;
                    case 21:
                        if((double)value>0.0)
                            objects.Blend=true;
                        if((double)value<=0.0) {
                            objects.Blend=false;
                            break;
                        }
                        break;
                    case 22:
                        if((double)value>0.0)
                            objects.Outdispel=true;
                        if((double)value<=0.0) {
                            objects.Outdispel=false;
                            break;
                        }
                        break;
                    case 23:
                        if((double)value>0.0)
                            objects.Invincible=true;
                        if((double)value<=0.0) {
                            objects.Invincible=false;
                            break;
                        }
                        break;
                }
            } else if(changetype==1) {
                switch(changevalue) {
                    case 0:
                        if(change==0) {
                            objects.r=value;
                            break;
                        }
                        if(change==1) {
                            objects.r+=value;
                            break;
                        }
                        if(change==2) {
                            objects.r-=value;
                            break;
                        }
                        break;
                    case 1:
                        if(change==0) {
                            objects.rdirection=value;
                            break;
                        }
                        if(change==1) {
                            objects.rdirection+=value;
                            break;
                        }
                        if(change==2) {
                            objects.rdirection-=value;
                            break;
                        }
                        break;
                    case 2:
                        if(change==0) {
                            objects.tiao=(int)value;
                            break;
                        }
                        if(change==1) {
                            objects.tiao+=(int)value;
                            break;
                        }
                        if(change==2) {
                            objects.tiao-=(int)value;
                            break;
                        }
                        break;
                    case 3:
                        if(change==0) {
                            objects.t=(int)value;
                            break;
                        }
                        if(change==1) {
                            objects.t+=(int)value;
                            break;
                        }
                        if(change==2) {
                            objects.t-=(int)value;
                            break;
                        }
                        break;
                    case 4:
                        if(change==0) {
                            objects.fdirection=value;
                            break;
                        }
                        if(change==1) {
                            objects.fdirection+=value;
                            break;
                        }
                        if(change==2) {
                            objects.fdirection-=value;
                            break;
                        }
                        break;
                    case 5:
                        if(change==0) {
                            objects.range=(int)value;
                            break;
                        }
                        if(change==1) {
                            objects.range+=(int)value;
                            break;
                        }
                        if(change==2) {
                            objects.range-=(int)value;
                            break;
                        }
                        break;
                    case 6:
                        if(change==0)
                            objects.speed=value;
                        else if(change==1)
                            objects.speed+=value;
                        else if(change==2)
                            objects.speed-=value;
                        objects.speedx=objects.speed*(float)Math.cos(MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.speed*(float)Math.sin(MathHelper.ToRadians(objects.speedd));
                        break;
                    case 7:
                        if(change==0)
                            objects.speedd=value;
                        else if(change==1)
                            objects.speedd+=value;
                        else if(change==2)
                            objects.speedd-=value;
                        objects.speedx=objects.speed*(float)Math.cos(MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.speed*(float)Math.sin(MathHelper.ToRadians(objects.speedd));
                        break;
                    case 8:
                        if(change==0)
                            objects.aspeed=value;
                        else if(change==1)
                            objects.aspeed+=value;
                        else if(change==2)
                            objects.aspeed-=value;
                        objects.aspeedx=objects.aspeed*(float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.aspeed*(float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 9:
                        if(change==0)
                            objects.aspeedd=value;
                        else if(change==1)
                            objects.aspeedd+=value;
                        else if(change==2)
                            objects.aspeedd-=value;
                        objects.aspeedx=objects.aspeed*(float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.aspeed*(float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 10:
                        if(change==0) {
                            objects.sonlife=(int)value;
                            break;
                        }
                        if(change==1) {
                            objects.sonlife+=(int)value;
                            break;
                        }
                        if(change==2) {
                            objects.sonlife-=(int)value;
                            break;
                        }
                        break;
                    case 11:
                        if(change==0) {
                            objects.type=(int)value;
                            break;
                        }
                        if(change==1) {
                            objects.type+=(float)(int)value;
                            break;
                        }
                        if(change==2) {
                            objects.type-=(float)(int)value;
                            break;
                        }
                        break;
                    case 12:
                        if(change==0) {
                            objects.wscale=value;
                            break;
                        }
                        if(change==1) {
                            objects.wscale+=value;
                            break;
                        }
                        if(change==2) {
                            objects.wscale-=value;
                            break;
                        }
                        break;
                    case 13:
                        if(change==0) {
                            objects.longs=value;
                            break;
                        }
                        if(change==1) {
                            objects.longs+=value;
                            break;
                        }
                        if(change==2) {
                            objects.longs-=value;
                            break;
                        }
                        break;
                    case 14:
                        if(change==0) {
                            objects.alpha=value;
                            break;
                        }
                        if(change==1) {
                            objects.alpha+=value;
                            break;
                        }
                        if(change==2) {
                            objects.alpha-=value;
                            break;
                        }
                        break;
                    case 15:
                        if(change==0) {
                            objects.sonspeed=value;
                            break;
                        }
                        if(change==1) {
                            objects.sonspeed+=value;
                            break;
                        }
                        if(change==2) {
                            objects.sonspeed-=value;
                            break;
                        }
                        break;
                    case 16:
                        if(change==0) {
                            objects.sonspeedd=value;
                            break;
                        }
                        if(change==1) {
                            objects.sonspeedd+=value;
                            break;
                        }
                        if(change==2) {
                            objects.sonspeedd-=value;
                            break;
                        }
                        break;
                    case 17:
                        if(change==0) {
                            objects.sonaspeed=value;
                            break;
                        }
                        if(change==1) {
                            objects.sonaspeed+=value;
                            break;
                        }
                        if(change==2) {
                            objects.sonaspeed-=value;
                            break;
                        }
                        break;
                    case 18:
                        if(change==0) {
                            objects.sonaspeedd=value;
                            break;
                        }
                        if(change==1) {
                            objects.sonaspeedd+=value;
                            break;
                        }
                        if(change==2) {
                            objects.sonaspeedd-=value;
                            break;
                        }
                        break;
                    case 19:
                        if(change==0) {
                            objects.xscale=value;
                            break;
                        }
                        if(change==1) {
                            objects.xscale+=value;
                            break;
                        }
                        if(change==2) {
                            objects.xscale-=value;
                            break;
                        }
                        break;
                    case 20:
                        if(change==0) {
                            objects.yscale=value;
                            break;
                        }
                        if(change==1) {
                            objects.yscale+=value;
                            break;
                        }
                        if(change==2) {
                            objects.yscale-=value;
                            break;
                        }
                        break;
                    case 21:
                        if((double)value>0.0)
                            objects.Blend=true;
                        if((double)value<=0.0) {
                            objects.Blend=false;
                            break;
                        }
                        break;
                    case 22:
                        if((double)value>0.0)
                            objects.Outdispel=true;
                        if((double)value<=0.0) {
                            objects.Outdispel=false;
                            break;
                        }
                        break;
                    case 23:
                        if((double)value>0.0)
                            objects.Invincible=true;
                        if((double)value<=0.0) {
                            objects.Invincible=false;
                            break;
                        }
                        break;
                }
            } else if(changetype==2) {
                switch(changevalue) {
                    case 0:
                        if(change==0) {
                            objects.r=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.r=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.r=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 1:
                        if(change==0) {
                            objects.rdirection=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.rdirection=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.rdirection=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 2:
                        if(change==0) {
                            objects.tiao=(int)((double)Float.parseFloat(region)+((double)value-(double)Float.parseFloat(region))*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==1) {
                            objects.tiao=(int)((double)Float.parseFloat(region)+(double)value*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==2) {
                            objects.tiao=(int)((double)Float.parseFloat(region)-(double)value*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        break;
                    case 3:
                        if(change==0) {
                            objects.t=(int)((double)Float.parseFloat(region)+((double)value-(double)Float.parseFloat(region))*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==1) {
                            objects.t=(int)((double)Float.parseFloat(region)+(double)value*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==2) {
                            objects.t=(int)((double)Float.parseFloat(region)-(double)value*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        break;
                    case 4:
                        if(change==0) {
                            objects.fdirection=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.fdirection=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.fdirection=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 5:
                        if(change==0) {
                            objects.range=(int)((double)Float.parseFloat(region)+((double)value-(double)Float.parseFloat(region))*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==1) {
                            objects.range=(int)((double)Float.parseFloat(region)+(double)value*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==2) {
                            objects.range=(int)((double)Float.parseFloat(region)-(double)value*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        break;
                    case 6:
                        if(change==0)
                            objects.speed=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==1)
                            objects.speed=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==2)
                            objects.speed=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        objects.speedx=objects.speed*(float)Math.cos(MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.speed*(float)Math.sin(MathHelper.ToRadians(objects.speedd));
                        break;
                    case 7:
                        if(change==0)
                            objects.speedd=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==1)
                            objects.speedd=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==2)
                            objects.speedd=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        objects.speedx=objects.speed*(float)Math.cos(MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.speed*(float)Math.sin(MathHelper.ToRadians(objects.speedd));
                        break;
                    case 8:
                        if(change==0)
                            objects.aspeed=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==1)
                            objects.aspeed=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==2)
                            objects.aspeed=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        objects.aspeedx=objects.aspeed*(float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.aspeed*(float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 9:
                        if(change==0)
                            objects.aspeedd=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==1)
                            objects.aspeedd=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==2)
                            objects.aspeedd=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        objects.aspeedx=objects.aspeed*(float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.aspeed*(float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 10:
                        if(change==0) {
                            objects.sonlife=(int)((double)Float.parseFloat(region)+((double)value-(double)Float.parseFloat(region))*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==1) {
                            objects.sonlife=(int)((double)Float.parseFloat(region)+(double)value*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==2) {
                            objects.sonlife=(int)((double)Float.parseFloat(region)-(double)value*Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        break;
                    case 11:
                        if(change==0) {
                            objects.type=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.type=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.type=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 12:
                        if(change==0) {
                            objects.wscale=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.wscale=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.wscale=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 13:
                        if(change==0) {
                            objects.longs=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.longs=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.longs=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 14:
                        if(change==0) {
                            objects.alpha=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.alpha=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.alpha=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 15:
                        if(change==0) {
                            objects.sonspeed=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.sonspeed=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.sonspeed=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 16:
                        if(change==0) {
                            objects.sonspeedd=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.sonspeedd=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.sonspeedd=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 17:
                        if(change==0) {
                            objects.sonaspeed=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.sonaspeed=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.sonaspeed=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 18:
                        if(change==0) {
                            objects.sonaspeedd=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.sonaspeedd=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.sonaspeedd=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 19:
                        if(change==0) {
                            objects.xscale=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.xscale=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.xscale=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 20:
                        if(change==0) {
                            objects.yscale=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.yscale=Float.parseFloat(region)+value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.yscale=Float.parseFloat(region)-value*(float)Math.sin(MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 21:
                        if((double)value>0.0)
                            objects.Blend=true;
                        if((double)value<=0.0) {
                            objects.Blend=false;
                            break;
                        }
                        break;
                    case 22:
                        if((double)value>0.0)
                            objects.Outdispel=true;
                        if((double)value<=0.0) {
                            objects.Outdispel=false;
                            break;
                        }
                        break;
                    case 23:
                        if((double)value>0.0)
                            objects.Invincible=true;
                        if((double)value<=0.0) {
                            objects.Invincible=false;
                            break;
                        }
                        break;
                }
            }
            --ctime;
            if(changetype==2&ctime==-1) {
                NeedDelete=true;
            } else {
                if(!(changetype!=2&ctime==0))
                    return;
                NeedDelete=true;
            }
        }

        public LExecution Clone() {
            try {
				return (LExecution)super.clone();
			} catch (CloneNotSupportedException e) {
				return null;
			}
        }
    }
