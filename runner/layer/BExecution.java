package runner.layer;

import runner.*;

public class BExecution {
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

        public void Update(Barrage objects) {
            if(changetype==1) {
                switch(changevalue) {
                    case 0:
                        if(change==0) {
                            objects.life=(int)value;
                            break;
                        }
                        if(change==1) {
                            objects.life+=(int)value;
                            break;
                        }
                        if(change==2) {
                            objects.life-=(int)value;
                            break;
                        }
                        break;
                    case 1:
                        if(change==0) {
                            objects.type=(int)value;
                            break;
                        }
                        if(change==1) {
                            objects.type+=(int)value;
                            break;
                        }
                        if(change==2) {
                            objects.type-=(int)value;
                            break;
                        }
                        break;
                    case 2:
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
                    case 3:
                        if(change==0) {
                            objects.hscale=value;
                            break;
                        }
                        if(change==1) {
                            objects.hscale+=value;
                            break;
                        }
                        if(change==2) {
                            objects.hscale-=value;
                            break;
                        }
                        break;
                    case 4:
                        if(change==0) {
                            objects.R=value;
                            break;
                        }
                        if(change==1) {
                            objects.R+=value;
                            break;
                        }
                        if(change==2) {
                            objects.R-=value;
                            break;
                        }
                        break;
                    case 5:
                        if(change==0) {
                            objects.G=value;
                            break;
                        }
                        if(change==1) {
                            objects.G+=value;
                            break;
                        }
                        if(change==2) {
                            objects.G-=value;
                            break;
                        }
                        break;
                    case 6:
                        if(change==0) {
                            objects.B=value;
                            break;
                        }
                        if(change==1) {
                            objects.B+=value;
                            break;
                        }
                        if(change==2) {
                            objects.B-=value;
                            break;
                        }
                        break;
                    case 7:
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
                    case 8:
                        if(change==0) {
                            objects.head=value;
                            break;
                        }
                        if(change==1) {
                            objects.head+=value;
                            break;
                        }
                        if(change==2) {
                            objects.head-=value;
                            break;
                        }
                        break;
                    case 9:
                        if(change==0)
                            objects.speed=value;
                        else if(change==1)
                            objects.speed+=value;
                        else if(change==2)
                            objects.speed-=value;
                        objects.speedx=objects.xscale*objects.speed*(float)Math.cos((double)MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.yscale*objects.speed*(float)Math.sin((double)MathHelper.ToRadians(objects.speedd));
                        break;
                    case 10:
                        if(change==0)
                            objects.speedd=value;
                        else if(change==1)
                            objects.speedd+=value;
                        else if(change==2)
                            objects.speedd-=value;
                        objects.speedx=objects.xscale*objects.speed*(float)Math.cos((double)MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.yscale*objects.speed*(float)Math.sin((double)MathHelper.ToRadians(objects.speedd));
                        break;
                    case 11:
                        if(change==0)
                            objects.aspeed=value;
                        else if(change==1)
                            objects.aspeed+=value;
                        else if(change==2)
                            objects.aspeed-=value;
                        objects.aspeedx=objects.xscale*objects.aspeed*(float)Math.cos((double)MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.yscale*objects.aspeed*(float)Math.sin((double)MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 12:
                        if(change==0)
                            objects.aspeedd=value;
                        else if(change==1)
                            objects.aspeedd+=value;
                        else if(change==2)
                            objects.aspeedd-=value;
                        objects.aspeedx=objects.xscale*objects.aspeed*(float)Math.cos((double)MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.yscale*objects.aspeed*(float)Math.sin((double)MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 13:
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
                    case 14:
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
                    case 15:
                        if((double)value>0.0)
                            objects.Mist=true;
                        if((double)value<=0.0) {
                            objects.Mist=false;
                            break;
                        }
                        break;
                    case 16:
                        if((double)value>0.0)
                            objects.Dispel=true;
                        if((double)value<=0.0) {
                            objects.Dispel=false;
                            break;
                        }
                        break;
                    case 17:
                        if((double)value>0.0)
                            objects.Blend=true;
                        if((double)value<=0.0) {
                            objects.Blend=false;
                            break;
                        }
                        break;
                    case 18:
                        if((double)value>0.0)
                            objects.Afterimage=true;
                        if((double)value<=0.0) {
                            objects.Afterimage=false;
                            break;
                        }
                        break;
                    case 19:
                        if((double)value>0.0)
                            objects.Outdispel=true;
                        if((double)value<=0.0) {
                            objects.Outdispel=false;
                            break;
                        }
                        break;
                    case 20:
                        if((double)value>0.0)
                            objects.Invincible=true;
                        if((double)value<=0.0) {
                            objects.Invincible=false;
                            break;
                        }
                        break;
                }
            } else if(changetype==0) {
                switch(changevalue) {
                    case 0:
                        if(change==0) {
                            objects.life=(int)(((double)objects.life*((double)ctime-1.0)+(double)value)/(double)ctime);
                            break;
                        }
                        if(change==1) {
                            objects.life+=(int)((double)value/(double)time);
                            break;
                        }
                        if(change==2) {
                            objects.life-=(int)((double)value/(double)time);
                            break;
                        }
                        break;
                    case 1:
                        if(change==0) {
                            objects.type=(int)(((double)objects.type*((double)ctime-1.0)+(double)value)/(double)ctime);
                            break;
                        }
                        if(change==1) {
                            objects.type+=(int)((double)value/(double)time);
                            break;
                        }
                        if(change==2) {
                            objects.type-=(int)((double)value/(double)time);
                            break;
                        }
                        break;
                    case 2:
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
                    case 3:
                        if(change==0) {
                            objects.hscale=(objects.hscale*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.hscale+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.hscale-=value/(float)time;
                            break;
                        }
                        break;
                    case 4:
                        if(change==0) {
                            objects.R=(objects.R*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.R+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.R-=value/(float)time;
                            break;
                        }
                        break;
                    case 5:
                        if(change==0) {
                            objects.G=(objects.G*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.G+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.G-=value/(float)time;
                            break;
                        }
                        break;
                    case 6:
                        if(change==0) {
                            objects.B=(objects.B*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.B+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.B-=value/(float)time;
                            break;
                        }
                        break;
                    case 7:
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
                    case 8:
                        if(change==0) {
                            objects.head=(objects.head*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.head+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.head-=value/(float)time;
                            break;
                        }
                        break;
                    case 9:
                        if(change==0)
                            objects.speed=(objects.speed*((float)ctime-1f)+value)/(float)ctime;
                        else if(change==1)
                            objects.speed+=value/(float)time;
                        else if(change==2)
                            objects.speed-=value/(float)time;
                        objects.speedx=objects.xscale*objects.speed*(float)Math.cos((double)MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.yscale*objects.speed*(float)Math.sin((double)MathHelper.ToRadians(objects.speedd));
                        break;
                    case 10:
                        if(change==0)
                            objects.speedd=(objects.speedd*((float)ctime-1f)+value)/(float)ctime;
                        else if(change==1)
                            objects.speedd+=value/(float)time;
                        else if(change==2)
                            objects.speedd-=value/(float)time;
                        objects.speedx=objects.xscale*objects.speed*(float)Math.cos((double)MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.yscale*objects.speed*(float)Math.sin((double)MathHelper.ToRadians(objects.speedd));
                        break;
                    case 11:
                        if(change==0)
                            objects.aspeed=(objects.aspeed*((float)ctime-1f)+value)/(float)ctime;
                        else if(change==1)
                            objects.aspeed+=value/(float)time;
                        else if(change==2)
                            objects.aspeed-=value/(float)time;
                        objects.aspeedx=objects.xscale*objects.aspeed*(float)Math.cos((double)MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.yscale*objects.aspeed*(float)Math.sin((double)MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 12:
                        if(change==0)
                            objects.aspeedd=(objects.aspeedd*((float)ctime-1f)+value)/(float)ctime;
                        else if(change==1)
                            objects.aspeedd+=value/(float)time;
                        else if(change==2)
                            objects.aspeedd-=value/(float)time;
                        objects.aspeedx=objects.xscale*objects.aspeed*(float)Math.cos((double)MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.yscale*objects.aspeed*(float)Math.sin((double)MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 13:
                        if(change==0) {
                            objects.xscale=(objects.xscale*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.xscale+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.xscale-=value/(float)time;
                            break;
                        }
                        break;
                    case 14:
                        if(change==0) {
                            objects.yscale=(objects.yscale*((float)ctime-1f)+value)/(float)ctime;
                            break;
                        }
                        if(change==1) {
                            objects.yscale+=value/(float)time;
                            break;
                        }
                        if(change==2) {
                            objects.yscale-=value/(float)time;
                            break;
                        }
                        break;
                    case 15:
                        if((double)value>0.0)
                            objects.Mist=true;
                        if((double)value<=0.0) {
                            objects.Mist=false;
                            break;
                        }
                        break;
                    case 16:
                        if((double)value>0.0)
                            objects.Dispel=true;
                        if((double)value<=0.0) {
                            objects.Dispel=false;
                            break;
                        }
                        break;
                    case 17:
                        if((double)value>0.0)
                            objects.Blend=true;
                        if((double)value<=0.0) {
                            objects.Blend=false;
                            break;
                        }
                        break;
                    case 18:
                        if((double)value>0.0)
                            objects.Afterimage=true;
                        if((double)value<=0.0) {
                            objects.Afterimage=false;
                            break;
                        }
                        break;
                    case 19:
                        if((double)value>0.0)
                            objects.Outdispel=true;
                        if((double)value<=0.0) {
                            objects.Outdispel=false;
                            break;
                        }
                        break;
                    case 20:
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
                            objects.life=(int)((double)Float.parseFloat(region)+((double)value-(double)Float.parseFloat(region))*Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==1) {
                            objects.life=(int)((double)Float.parseFloat(region)+(double)value*Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==2) {
                            objects.life=(int)((double)Float.parseFloat(region)-(double)value*Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        break;
                    case 1:
                        if(change==0) {
                            objects.type=(int)((double)Float.parseFloat(region)+((double)value-(double)Float.parseFloat(region))*Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==1) {
                            objects.type=(int)((double)Float.parseFloat(region)+(double)value*Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        if(change==2) {
                            objects.type=(int)((double)Float.parseFloat(region)-(double)value*Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime)))));
                            break;
                        }
                        break;
                    case 2:
                        if(change==0) {
                            objects.wscale=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.wscale=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.wscale=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 3:
                        if(change==0) {
                            objects.hscale=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.hscale=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.hscale=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 4:
                        if(change==0) {
                            objects.R=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.R=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.R=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 5:
                        if(change==0) {
                            objects.G=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.G=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.G=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 6:
                        if(change==0) {
                            objects.B=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.B=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.B=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 7:
                        if(change==0) {
                            objects.alpha=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.alpha=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.alpha=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 8:
                        if(change==0) {
                            objects.head=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.head=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.head=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 9:
                        if(change==0)
                            objects.speed=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==1)
                            objects.speed=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==2)
                            objects.speed=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        objects.speedx=objects.xscale*objects.speed*(float)Math.cos((double)MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.yscale*objects.speed*(float)Math.sin((double)MathHelper.ToRadians(objects.speedd));
                        break;
                    case 10:
                        if(change==0)
                            objects.speedd=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==1)
                            objects.speedd=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==2)
                            objects.speedd=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        objects.speedx=objects.xscale*objects.speed*(float)Math.cos((double)MathHelper.ToRadians(objects.speedd));
                        objects.speedy=objects.yscale*objects.speed*(float)Math.sin((double)MathHelper.ToRadians(objects.speedd));
                        break;
                    case 11:
                        if(change==0)
                            objects.aspeed=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==1)
                            objects.aspeed=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==2)
                            objects.aspeed=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        objects.aspeedx=objects.xscale*objects.aspeed*(float)Math.cos((double)MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.yscale*objects.aspeed*(float)Math.sin((double)MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 12:
                        if(change==0)
                            objects.aspeedd=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==1)
                            objects.aspeedd=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        else if(change==2)
                            objects.aspeedd=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                        objects.aspeedx=objects.xscale*objects.aspeed*(float)Math.cos((double)MathHelper.ToRadians(objects.aspeedd));
                        objects.aspeedy=objects.yscale*objects.aspeed*(float)Math.sin((double)MathHelper.ToRadians(objects.aspeedd));
                        break;
                    case 13:
                        if(change==0) {
                            objects.xscale=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.xscale=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.xscale=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 14:
                        if(change==0) {
                            objects.yscale=Float.parseFloat(region)+(value-Float.parseFloat(region))*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==1) {
                            objects.yscale=Float.parseFloat(region)+value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        if(change==2) {
                            objects.yscale=Float.parseFloat(region)-value*(float)Math.sin((double)MathHelper.ToRadians((float)(360.0/(double)time*((double)time-(double)ctime))));
                            break;
                        }
                        break;
                    case 15:
                        if((double)value>0.0)
                            objects.Mist=true;
                        if((double)value<=0.0) {
                            objects.Mist=false;
                            break;
                        }
                        break;
                    case 16:
                        if((double)value>0.0)
                            objects.Dispel=true;
                        if((double)value<=0.0) {
                            objects.Dispel=false;
                            break;
                        }
                        break;
                    case 17:
                        if((double)value>0.0)
                            objects.Blend=true;
                        if((double)value<=0.0) {
                            objects.Blend=false;
                            break;
                        }
                        break;
                    case 18:
                        if((double)value>0.0)
                            objects.Afterimage=true;
                        if((double)value<=0.0) {
                            objects.Afterimage=false;
                            break;
                        }
                        break;
                    case 19:
                        if((double)value>0.0)
                            objects.Outdispel=true;
                        if((double)value<=0.0) {
                            objects.Outdispel=false;
                            break;
                        }
                        break;
                    case 20:
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
    }
