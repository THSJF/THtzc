package runner.layer;

import java.util.*;
import runner.*;

public class Force implements Cloneable {
	private int clcount;
	private int clwait;
	public boolean NeedDelete;
	public int Searched;
	public int id;
	public int parentid;
	public int parentcolor;
	public float x;
	public float y;
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
	public float aspeed;
	public float aspeedx;
	public float aspeedy;
	public float aspeedd;
	public float addaspeed;
	public float addaspeedd;
	public boolean Suction;
	public boolean Repulsion;
	public float addspeed;
	public Force rand;
	public ArrayList<Event> Parentevents;
	public Force copys;

	public Force() {
	}

	public Force(float xs, float ys, int pc) {
		rand = new Force();
		Parentevents = new ArrayList<Event>();
		x = xs;
		y = ys;
		parentcolor = pc;
		begin = Layer.LayerArray.get(parentid).begin;
		life = Layer.LayerArray.get(parentid).end - Layer.LayerArray.get(parentid).begin + 1;
		halfw = 100;
		halfh = 100;
		type = 0;
		controlid = 1;
		speed = 0.0f;
		speedd = 0.0f;
		aspeed = 0.0f;
		aspeedd = 0.0f;
		Circle = false;
	}

	public void Update() {
		if (clcount == 1) {
			++clwait;
			if (clwait > 15) {
				clwait = 0;
				clcount = 0;
			}
		}
		if (!Time.Playing) {
			aspeedx = aspeed * (float)Math.cos(MathHelper.ToRadians(aspeedd));
			aspeedy = aspeed * (float)Math.sin(MathHelper.ToRadians(aspeedd));
			speedx = speed * (float)Math.cos(MathHelper.ToRadians(speedd));
			speedy = speed * (float)Math.sin(MathHelper.ToRadians(speedd));
			begin = (int)MathHelper.Clamp((float)begin, (float)Layer.LayerArray.get(parentid).begin, (float)(1 + Layer.LayerArray.get(parentid).end - Layer.LayerArray.get(parentid).begin));
			life = (int)MathHelper.Clamp((float)life, 1f, (float)(Layer.LayerArray.get(parentid).end - Layer.LayerArray.get(parentid).begin + 2 - begin));
		}
		if (!Time.Playing || !(Time.now >= begin & Time.now <= begin + life - 1))
			return;
		speedx += aspeedx;
		speedy += aspeedy;
		x += speedx;
		y += speedy;
		if (Circle) {
			if (Math.sqrt(((double)x - 4.0 - (double)Player.position.x) * ((double)x - 4.0 - (double)Player.position.x) + ((double)y + 16.0 - (double)Player.position.y) * ((double)y + 16.0 - (double)Player.position.y)) <= (double)Math.max(halfw, halfh)) {
				if (Suction) {
					float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, Player.position.x, Player.position.y));
					Player.position.x += addspeed * (float)Math.cos(MathHelper.ToRadians(degrees));
					Player.position.y += addspeed * (float)Math.sin(MathHelper.ToRadians(degrees));
				} else if (Repulsion) {
					float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, Player.position.x, Player.position.y));
					Player.position.x += addspeed * (float)Math.cos(MathHelper.ToRadians(180f + degrees));
					Player.position.y += addspeed * (float)Math.sin(MathHelper.ToRadians(180f + degrees));
				} else {
					Player.position.x += addspeed * (float)Math.cos(MathHelper.ToRadians(addaspeedd));
					Player.position.y += addspeed * (float)Math.sin(MathHelper.ToRadians(addaspeedd));
				}
				if (Player.position.x <= 4.5f)
					Player.position.x = 4.5f;
				if (Player.position.x >= 625.5f)
					Player.position.x = 625.5f;
				if (Player.position.y <= 4.5f)
					Player.position.y = 4.5f;
				if (Player.position.y >= 475.5f)
					Player.position.y = 475.5f;
			}
		} else if ((double)Math.abs(x - 4f - Player.position.x) <= (double)halfw & (double)Math.abs(y + 16f - Player.position.y) <= (double)halfh) {
			if (Suction) {
				float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, Player.position.x, Player.position.y));
				Player.position.x += addspeed * (float)Math.cos(MathHelper.ToRadians(degrees));
				Player.position.y += addspeed * (float)Math.sin(MathHelper.ToRadians(degrees));
			} else if (Repulsion) {
				float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, Player.position.x, Player.position.y));
				Player.position.x += addspeed * (float)Math.cos(MathHelper.ToRadians(180f + degrees));
				Player.position.y += addspeed * (float)Math.sin(MathHelper.ToRadians(180f + degrees));
			} else {
				Player.position.x += addspeed * (float)Math.cos(MathHelper.ToRadians(addaspeedd));
				Player.position.y += addspeed * (float)Math.sin(MathHelper.ToRadians(addaspeedd));
			}
			if (Player.position.x <= 4.5f)
				Player.position.x = 4.5f;
			if (Player.position.x >= 625.5f)
				Player.position.x = 625.5f;
			if (Player.position.y <= 4.5f)
				Player.position.y = 4.5f;
			if (Player.position.y >= 475.5f)
				Player.position.y = 475.5f;
		}
		for (Barrage barrage : Layer.LayerArray.get(parentid).Barrages) {
			if (barrage.Force) {
				if (Circle) {
					if (type == 0) {
						if (Math.sqrt(((double)x - 4.0 - (double)barrage.x) * ((double)x - 4.0 - (double)barrage.x) + ((double)y + 16.0 - (double)barrage.y) * ((double)y + 16.0 - (double)barrage.y)) <= (double)Math.max(halfw, halfh)) {
							if (Suction) {
								float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, barrage.x, barrage.y));
								barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(degrees));
								barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(degrees));
							} else if (Repulsion) {
								float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, barrage.x, barrage.y));
								barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(180f + degrees));
								barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(180f + degrees));
							} else {
								barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(addaspeedd));
								barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(addaspeedd));
							}
						}
					} else if (type == 1 && barrage.parentid == controlid - 1 & Math.sqrt(((double)x - 4.0 - (double)barrage.x) * ((double)x - 4.0 - (double)barrage.x) + ((double)y + 16.0 - (double)barrage.y) * ((double)y + 16.0 - (double)barrage.y)) <= (double)Math.max(halfw, halfh)) {
						if (Suction) {
							float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, barrage.x, barrage.y));
							barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(degrees));
							barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(degrees));
						} else if (Repulsion) {
							float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, barrage.x, barrage.y));
							barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(180f + degrees));
							barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(180f + degrees));
						} else {
							barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(addaspeedd));
							barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(addaspeedd));
						}
					}
				} else if (type == 0) {
					if ((double)Math.abs(x - 4f - barrage.x) <= (double)halfw & (double)Math.abs(y + 16f - barrage.y) <= (double)halfh) {
						if (Suction) {
							float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, barrage.x, barrage.y));
							barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(degrees));
							barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(degrees));
						} else if (Repulsion) {
							float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, barrage.x, barrage.y));
							barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(180f + degrees));
							barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(180f + degrees));
						} else {
							barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(addaspeedd));
							barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(addaspeedd));
						}
					}
				} else if (type == 1 && barrage.parentid == controlid - 1 & (double)Math.abs(x - 4f - barrage.x) <= (double)halfw & (double)Math.abs(y + 16f - barrage.y) <= (double)halfh) {
					if (Suction) {
						float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, barrage.x, barrage.y));
						barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(degrees));
						barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(degrees));
					} else if (Repulsion) {
						float degrees = (float)MathHelper.ToDegrees(Main.Twopointangle(x - 4f, y + 16f, barrage.x, barrage.y));
						barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(180f + degrees));
						barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(180f + degrees));
					} else {
						barrage.speedx += barrage.xscale * addaspeed * (float)Math.cos(MathHelper.ToRadians(addaspeedd));
						barrage.speedy += barrage.yscale * addaspeed * (float)Math.sin(MathHelper.ToRadians(addaspeedd));
					}
				}
			}
		}
	}

	@Override
	protected Force clone() throws CloneNotSupportedException {
		return (Force)super.clone();
	}

	public Force Clone() {
		try {
			Force f=clone();
			f.rand = rand.Clone();
			f.copys = copys.Clone();
			f.Parentevents = new ArrayList<>();
			for (Event e:Parentevents) {
				f.Parentevents.add(e.Clone());
			}
			return f;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public Force Copy() {
		try {
			return clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public void PreviewUpdate() {
		if (!(Time.now >= begin & Time.now <= begin + life - 1))
			return;
		speedx += aspeedx;
		speedy += aspeedy;
		x += speedx;
		y += speedy;
	}
}
