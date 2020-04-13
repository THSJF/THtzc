package runner.layer;

import runner.*;

public class CExecution {
	public int change;
	public int changetype;
	public int changevalue;
	public String region;
	public float value;
	public float value2;
	public int time;
	public int ctime;
	public boolean NeedDelete;

	public void Update() {
		if (changetype == 0) {
			switch (changevalue) {
				case 0:
					if (change == 0)
						Center.ospeed = (Center.ospeed * ((float)ctime - 1f) + value) / (float)ctime;
					else if (change == 1)
						Center.ospeed += value / (float)time;
					else if (change == 2)
						Center.ospeed -= value / (float)time;
					Center.speedx = Center.ospeed * (float)Math.cos(MathHelper.ToRadians(Center.ospeedd));
					Center.speedy = Center.ospeed * (float)Math.sin(MathHelper.ToRadians(Center.ospeedd));
					break;
				case 1:
					if (change == 0)
						Center.ospeedd = (Center.ospeedd * ((float)ctime - 1f) + value) / (float)ctime;
					else if (change == 1)
						Center.ospeedd += value / (float)time;
					else if (change == 2)
						Center.ospeedd -= value / (float)time;
					Center.speedx = Center.ospeed * (float)Math.cos(MathHelper.ToRadians(Center.ospeedd));
					Center.speedy = Center.ospeed * (float)Math.sin(MathHelper.ToRadians(Center.ospeedd));
					break;
				case 2:
					if (change == 0)
						Center.oaspeed = (Center.oaspeed * ((float)ctime - 1f) + value) / (float)ctime;
					else if (change == 1)
						Center.oaspeed += value / (float)time;
					else if (change == 2)
						Center.oaspeed -= value / (float)time;
					Center.aspeedx = Center.oaspeed * (float)Math.cos(MathHelper.ToRadians(Center.oaspeedd));
					Center.aspeedy = Center.oaspeed * (float)Math.sin(MathHelper.ToRadians(Center.oaspeedd));
					break;
				case 3:
					if (change == 0)
						Center.oaspeedd = (Center.oaspeedd * ((float)ctime - 1f) + value) / (float)ctime;
					else if (change == 1)
						Center.oaspeedd += value / (float)time;
					else if (change == 2)
						Center.oaspeedd -= value / (float)time;
					Center.aspeedx = Center.oaspeed * (float)Math.cos(MathHelper.ToRadians(Center.oaspeedd));
					Center.aspeedy = Center.oaspeed * (float)Math.sin(MathHelper.ToRadians(Center.oaspeedd));
					break;
			}
		} else if (changetype == 1) {
			switch (changevalue) {
				case 0:
					if (change == 0)
						Center.ospeed = value;
					else if (change == 1)
						Center.ospeed += value;
					else if (change == 2)
						Center.ospeed -= value;
					Center.speedx = Center.ospeed * (float)Math.cos(MathHelper.ToRadians(Center.ospeedd));
					Center.speedy = Center.ospeed * (float)Math.sin(MathHelper.ToRadians(Center.ospeedd));
					break;
				case 1:
					if (change == 0)
						Center.ospeedd = value;
					else if (change == 1)
						Center.ospeedd += value;
					else if (change == 2)
						Center.ospeedd -= value;
					Center.speedx = Center.ospeed * (float)Math.cos(MathHelper.ToRadians(Center.ospeedd));
					Center.speedy = Center.ospeed * (float)Math.sin(MathHelper.ToRadians(Center.ospeedd));
					break;
				case 2:
					if (change == 0)
						Center.oaspeed = value;
					else if (change == 1)
						Center.oaspeed += value;
					else if (change == 2)
						Center.oaspeed -= value;
					Center.aspeedx = Center.oaspeed * (float)Math.cos(MathHelper.ToRadians(Center.oaspeedd));
					Center.aspeedy = Center.oaspeed * (float)Math.sin(MathHelper.ToRadians(Center.oaspeedd));
					break;
				case 3:
					if (change == 0)
						Center.oaspeedd = value;
					else if (change == 1)
						Center.ospeedd += value;
					else if (change == 2)
						Center.ospeedd -= value;
					Center.aspeedx = Center.oaspeed * (float)Math.cos(MathHelper.ToRadians(Center.oaspeedd));
					Center.aspeedy = Center.oaspeed * (float)Math.sin(MathHelper.ToRadians(Center.oaspeedd));
					break;
			}
		} else if (changetype == 2) {
			switch (changevalue) {
				case 0:
					if (change == 0)
						Center.ospeed = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					else if (change == 1)
						Center.ospeed = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					else if (change == 2)
						Center.ospeed = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					Center.speedx = Center.ospeed * (float)Math.cos(MathHelper.ToRadians(Center.ospeedd));
					Center.speedy = Center.ospeed * (float)Math.sin(MathHelper.ToRadians(Center.ospeedd));
					break;
				case 1:
					if (change == 0)
						Center.ospeedd = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					else if (change == 1)
						Center.ospeedd = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					else if (change == 2)
						Center.ospeedd = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					Center.speedx = Center.ospeed * (float)Math.cos(MathHelper.ToRadians(Center.ospeedd));
					Center.speedy = Center.ospeed * (float)Math.sin(MathHelper.ToRadians(Center.ospeedd));
					break;
				case 2:
					if (change == 0)
						Center.oaspeed = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					else if (change == 1)
						Center.oaspeed = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					else if (change == 2)
						Center.oaspeed = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					Center.aspeedx = Center.oaspeed * (float)Math.cos(MathHelper.ToRadians(Center.oaspeedd));
					Center.aspeedy = Center.oaspeed * (float)Math.sin(MathHelper.ToRadians(Center.oaspeedd));
					break;
				case 3:
					if (change == 0)
						Center.oaspeedd = Float.parseFloat(region) + (value - Float.parseFloat(region)) * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					else if (change == 1)
						Center.oaspeedd = Float.parseFloat(region) + value * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					else if (change == 2)
						Center.oaspeedd = Float.parseFloat(region) - value * (float)Math.sin(MathHelper.ToRadians((float)(360.0 / (double)time * ((double)time - (double)ctime))));
					Center.aspeedx = Center.oaspeed * (float)Math.cos(MathHelper.ToRadians(Center.oaspeedd));
					Center.aspeedy = Center.oaspeed * (float)Math.sin(MathHelper.ToRadians(Center.oaspeedd));
					break;
			}
		} else if (changetype == 3)
			Center.ox = (float)(((double)Center.ox * 19.0 + (double)Player.position.x) / 20.0);
		else if (changetype == 4) {
			Center.ox = (float)(((double)Center.ox * 19.0 + (double)value) / 20.0);
			Center.oy = (float)(((double)Center.oy * 19.0 + (double)value2) / 20.0);
		}
		--ctime;
		if (changetype == 2 && ctime == -1) {
			NeedDelete = true;
		} else {
			if (changetype == 2 || ctime != 0)
				return;
			NeedDelete = true;
		}
	}
}
