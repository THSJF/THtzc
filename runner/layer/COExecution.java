package runner.layer;

import runner.*;

public class COExecution implements Cloneable {
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

	public void Update(Cover objects) {
		if (changetype == 0) {
			switch (changevalue) {
				case 0:
					if (change == 0) {
						objects.halfw = (int)(((double)objects.halfw * ((double)ctime - 1.0f) + (double)value) / (double)ctime);
						break;
					}
					if (change == 1) {
						objects.halfw += (int)((double)value / (double)time);
						break;
					}
					if (change == 2) {
						objects.halfw -= (int)((double)value / (double)time);
						break;
					}
					break;
				case 1:
					if (change == 0) {
						objects.halfh = (int)(((double)objects.halfh * ((double)ctime - 1.0f) + (double)value) / (double)ctime);
						break;
					}
					if (change == 1) {
						objects.halfh += (int)((double)value / (double)time);
						break;
					}
					if (change == 2) {
						objects.halfh -= (int)((double)value / (double)time);
						break;
					}
					break;
				case 2:
					if ((double)value > 0.0f)
						objects.Circle = true;
					if ((double)value <= 0.0f) {
						objects.Circle = false;
						break;
					}
					break;
				case 3:
					if (change == 0)
						objects.speed = (objects.speed * ((float)ctime - 1f) + value) / (float)ctime;
					else if (change == 1)
						objects.speed += value / (float)time;
					else if (change == 2)
						objects.speed -= value / (float)time;
					objects.speedx = objects.speed * (float)Math.cos(MathHelper.ToRadians(objects.speedd));
					objects.speedy = objects.speed * (float)Math.sin(MathHelper.ToRadians(objects.speedd));
					break;
				case 4:
					if (change == 0)
						objects.speedd = (objects.speedd * ((float)ctime - 1f) + value) / (float)ctime;
					else if (change == 1)
						objects.speedd += value / (float)time;
					else if (change == 2)
						objects.speedd -= value / (float)time;
					objects.speedx = objects.speed * (float)Math.cos(MathHelper.ToRadians(objects.speedd));
					objects.speedy = objects.speed * (float)Math.sin(MathHelper.ToRadians(objects.speedd));
					break;
				case 5:
					if (change == 0)
						objects.aspeed = (objects.aspeed * ((float)ctime - 1f) + value) / (float)ctime;
					else if (change == 1)
						objects.aspeed += value / (float)time;
					else if (change == 2)
						objects.aspeed -= value / (float)time;
					objects.aspeedx = objects.aspeed * (float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
					objects.aspeedy = objects.aspeed * (float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
					break;
				case 6:
					if (change == 0)
						objects.aspeedd = (int)(((double)objects.aspeedd * ((double)ctime - 1.0f) + (double)value) / (double)ctime);
					else if (change == 1)
						objects.aspeedd += value / (float)time;
					else if (change == 2)
						objects.aspeedd -= value / (float)time;
					objects.aspeedx = objects.aspeed * (float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
					objects.aspeedy = objects.aspeed * (float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
					break;
				case 7:
					if ((double)value > 0.0f)
						objects.type = 1;
					if ((double)value <= 0.0f) {
						objects.type = 0;
						break;
					}
					break;
				case 8:
					objects.controlid = (int)value;
					break;
				case 9:
					if (change == 0) {
						objects.x = (objects.x * ((float)ctime - 1f) + value) / (float)ctime;
						break;
					}
					if (change == 1) {
						objects.x += value / (float)time;
						break;
					}
					if (change == 2) {
						objects.x -= value / (float)time;
						break;
					}
					break;
				case 10:
					if (change == 0) {
						objects.y = (objects.y * ((float)ctime - 1f) + value) / (float)ctime;
						break;
					}
					if (change == 1) {
						objects.y += value / (float)time;
						break;
					}
					if (change == 2) {
						objects.y -= value / (float)time;
						break;
					}
					break;
			}
		} else if (changetype == 1) {
			switch (changevalue) {
				case 0:
					if (change == 0) {
						objects.halfw = (int)value;
						break;
					}
					if (change == 1) {
						objects.halfw += (int)value;
						break;
					}
					if (change == 2) {
						objects.halfw -= (int)value;
						break;
					}
					break;
				case 1:
					if (change == 0) {
						objects.halfh = (int)value;
						break;
					}
					if (change == 1) {
						objects.halfh += (int)value;
						break;
					}
					if (change == 2) {
						objects.halfh -= (int)value;
						break;
					}
					break;
				case 2:
					if ((double)value > 0.0f)
						objects.Circle = true;
					if ((double)value <= 0.0f) {
						objects.Circle = false;
						break;
					}
					break;
				case 3:
					if (change == 0)
						objects.speed = value;
					else if (change == 1)
						objects.speed += value;
					else if (change == 2)
						objects.speed -= value;
					objects.speedx = objects.speed * (float)Math.cos(MathHelper.ToRadians(objects.speedd));
					objects.speedy = objects.speed * (float)Math.sin(MathHelper.ToRadians(objects.speedd));
					break;
				case 4:
					if (change == 0)
						objects.speedd = value;
					else if (change == 1)
						objects.speedd += value;
					else if (change == 2)
						objects.speedd -= value;
					objects.speedx = objects.speed * (float)Math.cos(MathHelper.ToRadians(objects.speedd));
					objects.speedy = objects.speed * (float)Math.sin(MathHelper.ToRadians(objects.speedd));
					break;
				case 5:
					if (change == 0)
						objects.aspeed = value;
					else if (change == 1)
						objects.aspeed += value;
					else if (change == 2)
						objects.aspeed -= value;
					objects.aspeedx = objects.aspeed * (float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
					objects.aspeedy = objects.aspeed * (float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
					break;
				case 6:
					if (change == 0)
						objects.aspeedd = value;
					else if (change == 1)
						objects.aspeedd += value;
					else if (change == 2)
						objects.aspeedd -= value;
					objects.aspeedx = objects.aspeed * (float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
					objects.aspeedy = objects.aspeed * (float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
					break;
				case 7:
					if ((double)value > 0.0f)
						objects.type = 1;
					if ((double)value <= 0.0f) {
						objects.type = 0;
						break;
					}
					break;
				case 8:
					objects.controlid = (int)value;
					break;
				case 9:
					if (change == 0) {
						objects.x = value;
						break;
					}
					if (change == 1) {
						objects.x += value;
						break;
					}
					if (change == 2) {
						objects.x -= value;
						break;
					}
					break;
				case 10:
					if (change == 0) {
						objects.y = value;
						break;
					}
					if (change == 1) {
						objects.y += value;
						break;
					}
					if (change == 2) {
						objects.y -= value;
						break;
					}
					break;
			}
		} else if (changetype == 2) {
			switch (changevalue) {
				case 0:
					if (change == 0) {
						objects.halfw = (int)((double)Float.parseFloat(region) + ((double)value - (double)Float.parseFloat(region)) * Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime)))));
						break;
					}
					if (change == 1) {
						objects.halfw = (int)((double)Float.parseFloat(region) + (double)value * Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime)))));
						break;
					}
					if (change == 2) {
						objects.halfw = (int)((double)Float.parseFloat(region) - (double)value * Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime)))));
						break;
					}
					break;
				case 1:
					if (change == 0) {
						objects.halfh = (int)((double)Float.parseFloat(region) + ((double)value - (double)Float.parseFloat(region)) * Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime)))));
						break;
					}
					if (change == 1) {
						objects.halfh = (int)((double)Float.parseFloat(region) + (double)value * Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime)))));
						break;
					}
					if (change == 2) {
						objects.halfh = (int)((double)Float.parseFloat(region) - (double)value * Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime)))));
						break;
					}
					break;
				case 2:
					if ((double)value > 0.0f)
						objects.Circle = true;
					if ((double)value <= 0.0f) {
						objects.Circle = false;
						break;
					}
					break;
				case 3:
					if (change == 0)
						objects.speed = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					else if (change == 1)
						objects.speed = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					else if (change == 2)
						objects.speed = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					objects.speedx = objects.speed * (float)Math.cos(MathHelper.ToRadians(objects.speedd));
					objects.speedy = objects.speed * (float)Math.sin(MathHelper.ToRadians(objects.speedd));
					break;
				case 4:
					if (change == 0)
						objects.speedd = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					else if (change == 1)
						objects.speedd = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					else if (change == 2)
						objects.speedd = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					objects.speedx = objects.speed * (float)Math.cos(MathHelper.ToRadians(objects.speedd));
					objects.speedy = objects.speed * (float)Math.sin(MathHelper.ToRadians(objects.speedd));
					break;
				case 5:
					if (change == 0)
						objects.aspeed = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					else if (change == 1)
						objects.aspeed = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					else if (change == 2)
						objects.aspeed = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					objects.aspeedx = objects.aspeed * (float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
					objects.aspeedy = objects.aspeed * (float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
					break;
				case 6:
					if (change == 0)
						objects.aspeedd = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					else if (change == 1)
						objects.aspeedd = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					else if (change == 2)
						objects.aspeedd = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
					objects.aspeedx = objects.aspeed * (float)Math.cos(MathHelper.ToRadians(objects.aspeedd));
					objects.aspeedy = objects.aspeed * (float)Math.sin(MathHelper.ToRadians(objects.aspeedd));
					break;
				case 7:
					if ((double)value > 0.0f)
						objects.type = 1;
					if ((double)value <= 0.0f) {
						objects.type = 0;
						break;
					}
					break;
				case 8:
					objects.controlid = (int)value;
					break;
				case 9:
					if (change == 0) {
						objects.x = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
						break;
					}
					if (change == 1) {
						objects.x = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
						break;
					}
					if (change == 2) {
						objects.x = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
						break;
					}
					break;
				case 10:
					if (change == 0) {
						objects.y = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
						break;
					}
					if (change == 1) {
						objects.y = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
						break;
					}
					if (change == 2) {
						objects.y = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0f / (double)time * ((double)time - (double)ctime))));
						break;
					}
					break;
			}
		}
		--ctime;
		if (changetype == 2 & ctime == -1) {
			NeedDelete = true;
		} else {
			if (changetype == 2 || ctime != 0)
				return;
			NeedDelete = true;
		}
	}

	public COExecution Clone() {
		try {
			return (COExecution)super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
