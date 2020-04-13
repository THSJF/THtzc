package runner;

import com.badlogic.gdx.math.*;
import java.io.*;
import java.util.*;
import runner.*;
import runner.layer.*;
import java.util.regex.*;

public class Main {
	public static int frame = 0;
	public static HashMap<String,Integer> conditions = new HashMap<>();
	public static HashMap<String,Integer> results = new HashMap<>();
	public static HashMap<String,Integer> type = new HashMap<>();
	public static HashMap<String,Integer> conditions2 = new HashMap<>();
	public static HashMap<String,Integer> results2 = new HashMap<>();
	public static HashMap<String,Integer> results3 = new HashMap<>();
	public static HashMap<String,Integer> cconditions = new HashMap<>();
	public static HashMap<String,Integer> cresults = new HashMap<>();
	public static HashMap<String,Integer> lconditions = new HashMap<>();
	public static HashMap<String,Integer> lresults = new HashMap<>();
	public static HashMap<String,Integer> lresults2 = new HashMap<>();
	public static ArrayList<BarrageType> bgset = new ArrayList<BarrageType>();
	public static Random rand; 
	public static boolean Available;

	public Main() {
		Initialize("");
	}

	public void Initialize(String path) {
		Available = false;
		rand = new Random();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File("/storage/emulated/0/AppProjects/CrazyStormRT/CS/set.txt")));
			for (int index = 0;index < 228;++index) {
                String str = bf.readLine();
			//	System.out.println(str);
                BarrageType barrageType = new BarrageType();
				barrageType.origin = new Vector2(Integer.parseInt(str.split("_")[5]), Integer.parseInt(str.split("_")[6]));
                barrageType.origin0 = new Vector2(Integer.parseInt(str.split("_")[5]), Integer.parseInt(str.split("_")[6]));
				barrageType.pdr0 = Integer.parseInt(str.split("_")[7]);
                if (str.split("_").length >= 9) {
                    barrageType.color = Integer.parseInt(str.split("_")[8]);
                } else {
                    barrageType.color = -1;
                }
                bgset.add(barrageType);
            }
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		type.put("正比", 0);
		type.put("固定", 1);
		type.put("正弦", 2);
		conditions.put("", 0);
		conditions.put("当前帧", 0);
		conditions.put("X坐标", 1);
		conditions.put("Y坐标", 2);
		conditions.put("半径", 3);
		conditions.put("半径方向", 4);
		conditions.put("条数", 5);
		conditions.put("周期", 6);
		conditions.put("角度", 7);
		conditions.put("范围", 8);
		conditions.put("宽比", 9);
		conditions.put("高比", 10);
		conditions.put("不透明度", 11);
		conditions.put("朝向", 12);
		results.put("X坐标", 0);
		results.put("Y坐标", 1);
		results.put("半径", 2);
		results.put("半径方向", 3);
		results.put("条数", 4);
		results.put("周期", 5);
		results.put("角度", 6);
		results.put("范围", 7);
		results.put("速度", 8);
		results.put("速度方向", 9);
		results.put("加速度", 10);
		results.put("加速度方向", 11);
		results.put("生命", 12);
		results.put("类型", 13);
		results.put("宽比", 14);
		results.put("高比", 15);
		results.put("R", 16);
		results.put("G", 17);
		results.put("B", 18);
		results.put("不透明度", 19);
		results.put("朝向", 20);
		results.put("子弹速度", 21);
		results.put("子弹速度方向", 22);
		results.put("子弹加速度", 23);
		results.put("子弹加速度方向", 24);
		results.put("横比", 25);
		results.put("纵比", 26);
		results.put("雾化效果", 27);
		results.put("消除效果", 28);
		results.put("高光效果", 29);
		results.put("拖影效果", 30);
		results.put("出屏即消", 31);
		results.put("无敌状态", 32);
		conditions2.put("", 0);
		conditions2.put("当前帧", 0);
		conditions2.put("X坐标", 1);
		conditions2.put("Y坐标", 2);
		results2.put("生命", 0);
		results2.put("类型", 1);
		results2.put("宽比", 2);
		results2.put("高比", 3);
		results2.put("R", 4);
		results2.put("G", 5);
		results2.put("B", 6);
		results2.put("不透明度", 7);
		results2.put("朝向", 8);
		results2.put("子弹速度", 9);
		results2.put("子弹速度方向", 10);
		results2.put("子弹加速度", 11);
		results2.put("子弹加速度方向", 12);
		results2.put("横比", 13);
		results2.put("纵比", 14);
		results2.put("雾化效果", 15);
		results2.put("消除效果", 16);
		results2.put("高光效果", 17);
		results2.put("拖影效果", 18);
		results2.put("出屏即消", 19);
		results2.put("无敌状态", 20);
		results3.put("速度", 0);
		results3.put("速度方向", 1);
		results3.put("加速度", 2);
		results3.put("加速度方向", 3);
		cconditions.put("", 0);
		cconditions.put("当前帧", 0);
		cconditions.put("X坐标", 1);
		cconditions.put("Y坐标", 2);
		cconditions.put("半宽", 3);
		cconditions.put("半高", 4);
		cresults.put("半宽", 0);
		cresults.put("半高", 1);
		cresults.put("启用圆形", 2);
		cresults.put("速度", 3);
		cresults.put("速度方向", 4);
		cresults.put("加速度", 5);
		cresults.put("加速度方向", 6);
		cresults.put("类型", 7);
		cresults.put("ID", 8);
		cresults.put("X坐标", 9);
		cresults.put("Y坐标", 10);
		lconditions.put("", 0);
		lconditions.put("当前帧", 0);
		lconditions.put("半径", 1);
		lconditions.put("半径方向", 2);
		lconditions.put("条数", 3);
		lconditions.put("周期", 4);
		lconditions.put("角度", 5);
		lconditions.put("范围", 6);
		lconditions.put("宽比", 7);
		lconditions.put("长度", 8);
		lconditions.put("不透明度", 9);
		lresults.put("半径", 0);
		lresults.put("半径方向", 1);
		lresults.put("条数", 2);
		lresults.put("周期", 3);
		lresults.put("角度", 4);
		lresults.put("范围", 5);
		lresults.put("速度", 6);
		lresults.put("速度方向", 7);
		lresults.put("加速度", 8);
		lresults.put("加速度方向", 9);
		lresults.put("生命", 10);
		lresults.put("类型", 11);
		lresults.put("宽比", 12);
		lresults.put("长度", 13);
		lresults.put("不透明度", 14);
		lresults.put("子弹速度", 15);
		lresults.put("子弹速度方向", 16);
		lresults.put("子弹加速度", 17);
		lresults.put("子弹加速度方向", 18);
		lresults.put("横比", 19);
		lresults.put("纵比", 20);
		lresults.put("高光效果", 21);
		lresults.put("出屏即消", 22);
		lresults.put("无敌状态", 23);
		lresults2.put("生命", 0);
		lresults2.put("类型", 1);
		lresults2.put("宽比", 2);
		lresults2.put("长度", 3);
		lresults2.put("不透明度", 4);
		lresults2.put("子弹速度", 5);
		lresults2.put("子弹速度方向", 6);
		lresults2.put("子弹加速度", 7);
		lresults2.put("子弹加速度方向", 8);
		lresults2.put("横比", 9);
		lresults2.put("纵比", 10);
		lresults2.put("高光效果", 11);
		lresults2.put("出屏即消", 12);
		lresults2.put("无敌状态", 13);
	}

	public static void updateAll() {
		frame++;
		Time.Update();
		/*	Th902Interface.bullets.Clear();
		 for (int index1 = 0;index1 < Layer.LayerArray.size();++index1) {
		 Th902Interface.bullets.putRange(Layer.LayerArray.get(index1).Barrages);
		 }
		 */
		for (int index = 0;index < Layer.LayerArray.size();++index) {
			Layer.LayerArray.get(index).sort = index;
			Layer.LayerArray.get(index).Update();
		}

		for (int index1 = 0;index1 < Layer.LayerArray.size();++index1) {
			if (Layer.LayerArray.get(index1).Visible & !Time.Playing) {
				for (int index2 = 0;index2 < Layer.LayerArray.get(index1).ForceArray.size();++index2) {
					if (Layer.LayerArray.get(index1).ForceArray.get(index2).NeedDelete) {
						Layer.LayerArray.get(index1).ForceArray.remove(index2);
					}
				}
				for (int index2 = 0;index2 < Layer.LayerArray.get(index1).ReboundArray.size();++index2) {
					if (Layer.LayerArray.get(index1).ReboundArray.get(index2).NeedDelete) {
						Layer.LayerArray.get(index1).ReboundArray.remove(index2);
					}
				}
				for (int index2 = 0;index2 < Layer.LayerArray.get(index1).CoverArray.size();++index2) {
					if (Layer.LayerArray.get(index1).CoverArray.get(index2).NeedDelete) {
						Layer.LayerArray.get(index1).CoverArray.remove(index2);
					}
				}
				for (int index2 = 0;index2 < Layer.LayerArray.get(index1).LaseArray.size();++index2) {
					if (Layer.LayerArray.get(index1).LaseArray.get(index2).NeedDelete) {
						Layer.LayerArray.get(index1).LaseArray.remove(index2);
					}
				}
				for (int index2 = 0;index2 < Layer.LayerArray.get(index1).BatchArray.size();++index2) {
					if (Layer.LayerArray.get(index1).BatchArray.get(index2).NeedDelete) {
						Layer.LayerArray.get(index1).BatchArray.remove(index2);
					}
				}
			}
			for (int index2 = 0;index2 < Layer.LayerArray.get(index1).Barrages.size();++index2) {
				if (Layer.LayerArray.get(index1).Barrages.get(index2).Blend) {
					if (!Layer.LayerArray.get(index1).Barrages.get(index2).NeedDelete) {
					} else {
						Layer.LayerArray.get(index1).Barrages.remove(index2);
						--index2;
					}
				}
			}
			for (int index2 = 0;index2 < Layer.LayerArray.get(index1).Barrages.size();++index2) {
				if (!Layer.LayerArray.get(index1).Barrages.get(index2).NeedDelete) {
				} else {
					Layer.LayerArray.get(index1).Barrages.remove(index2);
					--index2;
				}
			}
		}

		for (int index = 0;index < Layer.LayerArray.size();++index) {
			if (Layer.LayerArray.get(index).NeedDelete) {
				Layer.LayerArray.remove(index);
			}
		}
		Center.Update();
	}

	public static float Twopointangle(float x2, float y2, float x1, float y1) {
		float num = x2 - (double)x1 == 0.0 ? (float)Math.atan((y2 - (double)y1) / (x2 - (double)x1 + 0.100000001490116)) : (float)Math.atan((y2 - (double)y1) / (x2 - (double)x1));
		if (x2 - (double)x1 < 0.0) {
			num += 3.141593f;
		}
		return num;
	}

	private static float CrossMul(Vector2 pt1, Vector2 pt2) {
		return (float)((double)pt1.x * pt2.y - pt1.y * (double)pt2.x);
	}

	private static boolean CheckCrose(Line line1, Line line2) {
		Vector2 pt1_1 = new Vector2();
		Vector2 pt1_2 = new Vector2();
		Vector2 pt2 = new Vector2();
		pt1_1.x = line2.Start.x - line1.End.x;
		pt1_1.y = line2.Start.y - line1.End.y;
		pt1_2.x = line2.End.x - line1.End.x;
		pt1_2.y = line2.End.y - line1.End.y;
		pt2.x = line1.Start.x - line1.End.x;
		pt2.y = line1.Start.y - line1.End.y;
		return (double)CrossMul(pt1_1, pt2) * CrossMul(pt1_2, pt2) <= 0.0;
	}

	public static boolean CheckTwoLineCrose(Line line1, Line line2) {
		if (CheckCrose(line1, line2)) {
			return CheckCrose(line2, line1);
		}
		return false;
	}
	public static void OpenMbgFile(String path) throws FileNotFoundException, IOException, NumberFormatException {
		BufferedReader streamReader = new BufferedReader(new FileReader(new File(path)));
		if (streamReader.readLine().equals("Crazy Storm Data 1.01")) {
			Available = true;
			Layer.Clear();
			Center.Clear();
			Time.Clear();
			String source = streamReader.readLine();
			if (source.contains("GlobalEvents")) {
				int num1 = Integer.parseInt(source.split(Pattern.quote(" "))[0]);
				for (int index = 0;index < num1;++index) {
					String str = streamReader.readLine();
					Time.GECount.add(Integer.parseInt(str.split("_")[0]) - 1);
					GlobalEvent globalEvent = new GlobalEvent();
					globalEvent.gotocondition = Integer.parseInt(str.split("_")[1]);
					globalEvent.gotoopreator = str.split("_")[2];
					globalEvent.gotocvalue = Integer.parseInt(str.split("_")[3]);
					globalEvent.isgoto = (Boolean.parseBoolean(str.split("_")[4]) ? 1 : 0) != 0;
					globalEvent.gototime = Integer.parseInt(str.split("_")[5]);
					globalEvent.gotowhere = Integer.parseInt(str.split("_")[6]);
					globalEvent.quakecondition = Integer.parseInt(str.split("_")[7]);
					globalEvent.quakeopreator = str.split("_")[8];
					globalEvent.quakecvalue = Integer.parseInt(str.split("_")[9]);
					globalEvent.isquake = (Boolean.parseBoolean(str.split("_")[10]) ? 1 : 0) != 0;
					globalEvent.quaketime = Integer.parseInt(str.split("_")[11]);
					globalEvent.quakelevel = Integer.parseInt(str.split("_")[12]);
					globalEvent.stopcondition = Integer.parseInt(str.split("_")[13]);
					globalEvent.stopopreator = str.split("_")[14];
					globalEvent.stopcvalue = Integer.parseInt(str.split("_")[15]);
					globalEvent.isstop = (Boolean.parseBoolean(str.split("_")[16]) ? 1 : 0) != 0;
					globalEvent.stoptime = Integer.parseInt(str.split("_")[17]);
					globalEvent.stoplevel = Integer.parseInt(str.split("_")[18]);
					if (Time.GE.size() < Integer.parseInt(str.split("_")[0])) {
						int num2 = 0;
						while (true) {
							if (num2 < Integer.parseInt(str.split("_")[0])) {
								GlobalEvent g=new GlobalEvent();
								g.gotocondition = -1;
								g.quakecondition = -1;
								g.stopcondition = -1;
								g.stoplevel = -1;
								Time.GE.add(g);     
								++num2;
							} else {
								break;
							}
						}
					}
					Time.GE.set(Integer.parseInt(str.split("_")[0]) - 1, globalEvent);
				}
				source = streamReader.readLine();
			}
			if (source.contains("Sounds")) {
				int num = Integer.parseInt(source.split(Pattern.quote(" "))[0]);
				for (int index = 0;index < num;++index) {
					streamReader.readLine();
				}
				source = streamReader.readLine();
			}
			if (source.contains(",")) {
				Center.Available = true;
				Center.x = Float.parseFloat(source.split(":")[1].split(Pattern.quote(","))[0]);
				Center.y = Float.parseFloat(source.split(":")[1].split(Pattern.quote(","))[1]);
				if (source.split(":")[1].split(Pattern.quote(",")).length >= 7) {
					Center.speed = Float.parseFloat(source.split(":")[1].split(Pattern.quote(","))[2]);
					Center.speedd = Float.parseFloat(source.split(":")[1].split(Pattern.quote(","))[3]);
					Center.aspeed = Float.parseFloat(source.split(":")[1].split(Pattern.quote(","))[4]);
					Center.aspeedd = Float.parseFloat(source.split(":")[1].split(Pattern.quote(","))[5]);
					int index = 0;
					while (true) {
						if (index < source.split(":")[1].split(Pattern.quote(","))[6].split(";").length - 1) {
							Center.events.add(source.split(":")[1].split(Pattern.quote(","))[6].split(";")[index]);
							++index;
						} else
							break;
					}
				}
			} else {
				Center.Available = false;
			}
			Time.total = Integer.parseInt(streamReader.readLine().split(":")[1]);
			for (int index1 = 0;index1 < 4;++index1) {
				String str1 = streamReader.readLine();
				if (!str1.split(":")[1].split(Pattern.quote(","))[0].equals("empty")) {
					new Layer(str1.split(":")[1].split(Pattern.quote(","))[0], Integer.parseInt(str1.split(":")[1].split(Pattern.quote(","))[1]), Integer.parseInt(str1.split(":")[1].split(Pattern.quote(","))[2]));
					int num1 = Integer.parseInt(str1.split(":")[1].split(Pattern.quote(","))[3]);
					for (int index2 = 0;index2 < num1;++index2) {
						String str2 = streamReader.readLine();
						Batch batch = new Batch(Float.parseFloat(str2.split(Pattern.quote(","))[6]), Float.parseFloat(str2.split(Pattern.quote(","))[7]), Layer.LayerArray.get(Layer.LayerArray.size() - Layer.selection - 1).color);
						batch.id = Integer.parseInt(str2.split(Pattern.quote(","))[0]);
						batch.parentid = Integer.parseInt(str2.split(Pattern.quote(","))[1]);
						batch.Binding = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[2]) ? 1 : 0) != 0;
						batch.bindid = Integer.parseInt(str2.split(Pattern.quote(","))[3]);
						batch.Bindwithspeedd = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[4]) ? 1 : 0) != 0;
						batch.begin = Integer.parseInt(str2.split(Pattern.quote(","))[8]);
						batch.life = Integer.parseInt(str2.split(Pattern.quote(","))[9]);
						batch.fx = Float.parseFloat(str2.split(Pattern.quote(","))[10]);
						batch.fy = Float.parseFloat(str2.split(Pattern.quote(","))[11]);
						batch.r = Integer.parseInt(str2.split(Pattern.quote(","))[12]);
						batch.rdirection = Float.parseFloat(str2.split(Pattern.quote(","))[13]);
						String str3 = str2.split(Pattern.quote(","))[14].replace("{", "").replace("}", "");
						batch.rdirections.x = Float.parseFloat(str3.split(Pattern.quote(" "))[0].split(":")[1]);
						batch.rdirections.y = Float.parseFloat(str3.split(Pattern.quote(" "))[1].split(":")[1]);
						batch.tiao = Integer.parseInt(str2.split(Pattern.quote(","))[15]);
						batch.t = Integer.parseInt(str2.split(Pattern.quote(","))[16]);
						batch.fdirection = Float.parseFloat(str2.split(Pattern.quote(","))[17]);
						String str4 = str2.split(Pattern.quote(","))[18].replace("{", "").replace("}", "");
						batch.fdirections.x = Float.parseFloat(str4.split(Pattern.quote(" "))[0].split(":")[1]);
						batch.fdirections.y = Float.parseFloat(str4.split(Pattern.quote(" "))[1].split(":")[1]);
						batch.range = Integer.parseInt(str2.split(Pattern.quote(","))[19]);
						batch.speed = Float.parseFloat(str2.split(Pattern.quote(","))[20]);
						batch.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[21]);
						String str5 = str2.split(Pattern.quote(","))[22].replace("{", "").replace("}", "");
						batch.speedds.x = Float.parseFloat(str5.split(Pattern.quote(" "))[0].split(":")[1]);
						batch.speedds.y = Float.parseFloat(str5.split(Pattern.quote(" "))[1].split(":")[1]);
						batch.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[23]);
						batch.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[24]);
						String str6 = str2.split(Pattern.quote(","))[25].replace("{", "").replace("}", "");
						batch.aspeedds.x = Float.parseFloat(str6.split(Pattern.quote(" "))[0].split(":")[1]);
						batch.aspeedds.y = Float.parseFloat(str6.split(Pattern.quote(" "))[1].split(":")[1]);
						batch.sonlife = Integer.parseInt(str2.split(Pattern.quote(","))[26]);
						batch.type = Integer.parseInt(str2.split(Pattern.quote(","))[27]);
						batch.wscale = Float.parseFloat(str2.split(Pattern.quote(","))[28]);
						batch.hscale = Float.parseFloat(str2.split(Pattern.quote(","))[29]);
						batch.colorR = Integer.parseInt(str2.split(Pattern.quote(","))[30]);
						batch.colorG = Integer.parseInt(str2.split(Pattern.quote(","))[31]);
						batch.colorB = Integer.parseInt(str2.split(Pattern.quote(","))[32]);
						batch.alpha = Integer.parseInt(str2.split(Pattern.quote(","))[33]);
						batch.head = Float.parseFloat(str2.split(Pattern.quote(","))[34]);
						String str7 = str2.split(Pattern.quote(","))[35].replace("{", "").replace("}", "");
						batch.heads.x = Float.parseFloat(str7.split(Pattern.quote(" "))[0].split(":")[1]);
						batch.heads.y = Float.parseFloat(str7.split(Pattern.quote(" "))[1].split(":")[1]);
						batch.Withspeedd = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[36]) ? 1 : 0) != 0;
						batch.sonspeed = Float.parseFloat(str2.split(Pattern.quote(","))[37]);
						batch.sonspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[38]);
						String str8 = str2.split(Pattern.quote(","))[39].replace("{", "").replace("}", "");
						batch.sonspeedds.x = Float.parseFloat(str8.split(Pattern.quote(" "))[0].split(":")[1]);
						batch.sonspeedds.y = Float.parseFloat(str8.split(Pattern.quote(" "))[1].split(":")[1]);
						batch.sonaspeed = Float.parseFloat(str2.split(Pattern.quote(","))[40]);
						batch.sonaspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[41]);
						String str9 = str2.split(Pattern.quote(","))[42].replace("{", "").replace("}", "");
						batch.sonaspeedds.x = Float.parseFloat(str9.split(Pattern.quote(" "))[0].split(":")[1]);
						batch.sonaspeedds.y = Float.parseFloat(str9.split(Pattern.quote(" "))[1].split(":")[1]);
						batch.xscale = Float.parseFloat(str2.split(Pattern.quote(","))[43]);
						batch.yscale = Float.parseFloat(str2.split(Pattern.quote(","))[44]);
						batch.Mist = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[45]) ? 1 : 0) != 0;
						batch.Dispel = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[46]) ? 1 : 0) != 0;
						batch.Blend = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[47]) ? 1 : 0) != 0;
						batch.Afterimage = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[48]) ? 1 : 0) != 0;
						batch.Outdispel = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[49]) ? 1 : 0) != 0;
						batch.Invincible = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[50]) ? 1 : 0) != 0;
						String str10 = str2.split(Pattern.quote(","))[51];
						int idx1 = 0;
						while (true) {
							if (idx1 < str10.split("&").length - 1) {
								String str11 = str10.split("&")[idx1];
								Event _event = new Event(idx1);
								_event.tag = str11.split(Pattern.quote("|"))[0];
								_event.t = Integer.parseInt(str11.split(Pattern.quote("|"))[1]);
								_event.addtime = Integer.parseInt(str11.split(Pattern.quote("|"))[2]);
								int index3 = 0;
								while (true) {
									if (index3 < str11.split(Pattern.quote("|"))[3].split(";").length - 1) {
										_event.events.add(str11.split(Pattern.quote("|"))[3].split(";")[index3]);
										++index3;
									} else
										break;
								}
								batch.Parentevents.add(_event);
								++idx1;
							} else
								break;
						}
						String str12 = str2.split(Pattern.quote(","))[52];
						int idx2 = 0;
						while (true) {
							if (idx2 < str12.split("&").length - 1) {
								String str11 = str12.split("&")[idx2];
								Event _event = new Event(idx2);
								_event.tag = str11.split(Pattern.quote("|"))[0];
								_event.t = Integer.parseInt(str11.split(Pattern.quote("|"))[1]);
								_event.addtime = Integer.parseInt(str11.split(Pattern.quote("|"))[2]);
								int index3 = 0;
								while (true) {
									if (index3 < str11.split(Pattern.quote("|"))[3].split(";").length - 1) {
										_event.events.add(str11.split(Pattern.quote("|"))[3].split(";")[index3]);
										++index3;
									} else {
										break;
									}
								}
								batch.Sonevents.add(_event);
								++idx2;
							} else {
								break;
							}
						}
						batch.rand.fx = Float.parseFloat(str2.split(Pattern.quote(","))[53]);
						batch.rand.fy = Float.parseFloat(str2.split(Pattern.quote(","))[54]);
						batch.rand.r = Integer.parseInt(str2.split(Pattern.quote(","))[55]);
						batch.rand.rdirection = Float.parseFloat(str2.split(Pattern.quote(","))[56]);
						batch.rand.tiao = Integer.parseInt(str2.split(Pattern.quote(","))[57]);
						batch.rand.t = Integer.parseInt(str2.split(Pattern.quote(","))[58]);
						batch.rand.fdirection = Float.parseFloat(str2.split(Pattern.quote(","))[59]);
						batch.rand.range = Integer.parseInt(str2.split(Pattern.quote(","))[60]);
						batch.rand.speed = Float.parseFloat(str2.split(Pattern.quote(","))[61]);
						batch.rand.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[62]);
						batch.rand.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[63]);
						batch.rand.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[64]);
						batch.rand.head = Float.parseFloat(str2.split(Pattern.quote(","))[65]);
						batch.rand.sonspeed = Float.parseFloat(str2.split(Pattern.quote(","))[66]);
						batch.rand.sonspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[67]);
						batch.rand.sonaspeed = Float.parseFloat(str2.split(Pattern.quote(","))[68]);
						batch.rand.sonaspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[69]);
						if (str2.split(Pattern.quote(",")).length >= 72) {
							batch.Cover = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[70]) ? 1 : 0) != 0;
							batch.Rebound = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[71]) ? 1 : 0) != 0;
							batch.Force = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[72]) ? 1 : 0) != 0;
						}
						if (str2.split(Pattern.quote(",")).length >= 74)
							batch.Deepbind = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[73]) ? 1 : 0) != 0;
						Layer.LayerArray.get(index1).BatchArray.add(batch);
					}
					if (str1.split(":")[1].split(Pattern.quote(",")).length >= 7) {
						int num2 = Integer.parseInt(str1.split(":")[1].split(Pattern.quote(","))[4]);
						for (int index2 = 0;index2 < num2;++index2) {
							String str2 = streamReader.readLine();
							Lase lase = new Lase(Float.parseFloat(str2.split(Pattern.quote(","))[6]), Float.parseFloat(str2.split(Pattern.quote(","))[7]), Layer.LayerArray.get(Layer.LayerArray.size() - Layer.selection - 1).color);
							lase.id = Integer.parseInt(str2.split(Pattern.quote(","))[0]);
							lase.parentid = Integer.parseInt(str2.split(Pattern.quote(","))[1]);
							lase.Binding = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[2]) ? 1 : 0) != 0;
							lase.bindid = Integer.parseInt(str2.split(Pattern.quote(","))[3]);
							lase.Bindwithspeedd = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[4]) ? 1 : 0) != 0;
							lase.begin = Integer.parseInt(str2.split(Pattern.quote(","))[8]);
							lase.life = Integer.parseInt(str2.split(Pattern.quote(","))[9]);
							lase.r = Integer.parseInt(str2.split(Pattern.quote(","))[10]);
							lase.rdirection = Float.parseFloat(str2.split(Pattern.quote(","))[11]);
							String str3 = str2.split(Pattern.quote(","))[12].replace("{", "").replace("}", "");
							lase.rdirections.x = Float.parseFloat(str3.split(Pattern.quote(" "))[0].split(":")[1]);
							lase.rdirections.y = Float.parseFloat(str3.split(Pattern.quote(" "))[1].split(":")[1]);
							lase.tiao = Integer.parseInt(str2.split(Pattern.quote(","))[13]);
							lase.t = Integer.parseInt(str2.split(Pattern.quote(","))[14]);
							lase.fdirection = Float.parseFloat(str2.split(Pattern.quote(","))[15]);
							String str4 = str2.split(Pattern.quote(","))[16].replace("{", "").replace("}", "");
							lase.fdirections.x = Float.parseFloat(str4.split(Pattern.quote(" "))[0].split(":")[1]);
							lase.fdirections.y = Float.parseFloat(str4.split(Pattern.quote(" "))[1].split(":")[1]);
							lase.range = Integer.parseInt(str2.split(Pattern.quote(","))[17]);
							lase.speed = Float.parseFloat(str2.split(Pattern.quote(","))[18]);
							lase.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[19]);
							String str5 = str2.split(Pattern.quote(","))[20].replace("{", "").replace("}", "");
							lase.speedds.x = Float.parseFloat(str5.split(Pattern.quote(" "))[0].split(":")[1]);
							lase.speedds.y = Float.parseFloat(str5.split(Pattern.quote(" "))[1].split(":")[1]);
							lase.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[21]);
							lase.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[22]);
							String str6 = str2.split(Pattern.quote(","))[23].replace("{", "").replace("}", "");
							lase.aspeedds.x = Float.parseFloat(str6.split(Pattern.quote(" "))[0].split(":")[1]);
							lase.aspeedds.y = Float.parseFloat(str6.split(Pattern.quote(" "))[1].split(":")[1]);
							lase.sonlife = Integer.parseInt(str2.split(Pattern.quote(","))[24]);
							lase.type = Integer.parseInt(str2.split(Pattern.quote(","))[25]);
							lase.wscale = Float.parseFloat(str2.split(Pattern.quote(","))[26]);
							lase.longs = Float.parseFloat(str2.split(Pattern.quote(","))[27]);
							lase.alpha = Integer.parseInt(str2.split(Pattern.quote(","))[28]);
							lase.Ray = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[29]) ? 1 : 0) != 0;
							lase.sonspeed = Float.parseFloat(str2.split(Pattern.quote(","))[30]);
							lase.sonspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[31]);
							String str7 = str2.split(Pattern.quote(","))[32].replace("{", "").replace("}", "");
							lase.sonspeedds.x = Float.parseFloat(str7.split(Pattern.quote(" "))[0].split(":")[1]);
							lase.sonspeedds.y = Float.parseFloat(str7.split(Pattern.quote(" "))[1].split(":")[1]);
							lase.sonaspeed = Float.parseFloat(str2.split(Pattern.quote(","))[33]);
							lase.sonaspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[34]);
							String str8 = str2.split(Pattern.quote(","))[35].replace("{", "").replace("}", "");
							lase.sonaspeedds.x = Float.parseFloat(str8.split(Pattern.quote(" "))[0].split(":")[1]);
							lase.sonaspeedds.y = Float.parseFloat(str8.split(Pattern.quote(" "))[1].split(":")[1]);
							lase.xscale = Float.parseFloat(str2.split(Pattern.quote(","))[36]);
							lase.yscale = Float.parseFloat(str2.split(Pattern.quote(","))[37]);
							lase.Blend = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[38]) ? 1 : 0) != 0;
							lase.Outdispel = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[39]) ? 1 : 0) != 0;
							lase.Invincible = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[40]) ? 1 : 0) != 0;
							String str9 = str2.split(Pattern.quote(","))[42];
							int idx1 = 0;
							while (true) {
								if (idx1 < str9.split("&").length - 1) {
									String str10 = str9.split("&")[idx1];
									Event _event = new Event(idx1);
									_event.tag = str10.split(Pattern.quote("|"))[0];
									_event.t = Integer.parseInt(str10.split(Pattern.quote("|"))[1]);
									_event.addtime = Integer.parseInt(str10.split(Pattern.quote("|"))[2]);
                            		int index3 = 0;
									while (true) {
										if (index3 < str10.split(Pattern.quote("|"))[3].split(";").length - 1) {
											_event.events.add(str10.split(Pattern.quote("|"))[3].split(";")[index3]);
											++index3;
										} else
											break;
									}
									lase.Parentevents.add(_event);
									++idx1;
								} else
									break;
							}
							String str11 = str2.split(Pattern.quote(","))[43];
							int idx2 = 0;
							while (true) {
								if (idx2 < str11.split("&").length - 1) {
									String str10 = str11.split("&")[idx2];
									Event _event = new Event(idx2);
									_event.tag = str11.split(Pattern.quote("|"))[0];
									_event.t = Integer.parseInt(str11.split(Pattern.quote("|"))[1]);
									_event.addtime = Integer.parseInt(str11.split(Pattern.quote("|"))[2]);
									int index3 = 0;
									while (true) {
										if (index3 < str10.split(Pattern.quote("|"))[3].split(";").length - 1) {
											_event.events.add(str10.split(Pattern.quote("|"))[3].split(";")[index3]);
											++index3;
										} else
											break;
									}
									lase.Sonevents.add(_event);
									++idx2;
								} else
									break;
							}
							lase.rand.r = Integer.parseInt(str2.split(Pattern.quote(","))[44]);
							lase.rand.rdirection = Float.parseFloat(str2.split(Pattern.quote(","))[45]);
							lase.rand.tiao = Integer.parseInt(str2.split(Pattern.quote(","))[46]);
							lase.rand.t = Integer.parseInt(str2.split(Pattern.quote(","))[47]);
							lase.rand.fdirection = Float.parseFloat(str2.split(Pattern.quote(","))[48]);
							lase.rand.range = Integer.parseInt(str2.split(Pattern.quote(","))[49]);
							lase.rand.speed = Float.parseFloat(str2.split(Pattern.quote(","))[50]);
							lase.rand.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[51]);
							lase.rand.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[52]);
							lase.rand.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[53]);
							lase.rand.sonspeed = Float.parseFloat(str2.split(Pattern.quote(","))[54]);
							lase.rand.sonspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[55]);
							lase.rand.sonaspeed = Float.parseFloat(str2.split(Pattern.quote(","))[56]);
							lase.rand.sonaspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[57]);
							if (str2.split(Pattern.quote(",")).length >= 59)
								lase.Deepbind = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[58]) ? 1 : 0) != 0;
							Layer.LayerArray.get(index1).LaseArray.add(lase);
						}
						int num3 = Integer.parseInt(str1.split(":")[1].split(Pattern.quote(","))[5]);
						for (int index2 = 0;index2 < num3;++index2) {
							String str2 = streamReader.readLine();
							Cover cover = new Cover(Float.parseFloat(str2.split(Pattern.quote(","))[2]), Float.parseFloat(str2.split(Pattern.quote(","))[3]), Layer.LayerArray.get(Layer.LayerArray.size() - Layer.selection - 1).color);
							cover.id = Integer.parseInt(str2.split(Pattern.quote(","))[0]);
							cover.parentid = Integer.parseInt(str2.split(Pattern.quote(","))[1]);
							cover.begin = Integer.parseInt(str2.split(Pattern.quote(","))[4]);
							cover.life = Integer.parseInt(str2.split(Pattern.quote(","))[5]);
							cover.halfw = Integer.parseInt(str2.split(Pattern.quote(","))[6]);
							cover.halfh = Integer.parseInt(str2.split(Pattern.quote(","))[7]);
							cover.Circle = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[8]) ? 1 : 0) != 0;
							cover.type = Integer.parseInt(str2.split(Pattern.quote(","))[9]);
							cover.controlid = Integer.parseInt(str2.split(Pattern.quote(","))[10]);
							cover.speed = Float.parseFloat(str2.split(Pattern.quote(","))[11]);
							cover.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[12]);
							String str3 = str2.split(Pattern.quote(","))[13].replace("{", "").replace("}", "");
							cover.speedds.x = Float.parseFloat(str3.split(Pattern.quote(" "))[0].split(":")[1]);
							cover.speedds.y = Float.parseFloat(str3.split(Pattern.quote(" "))[1].split(":")[1]);
							cover.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[14]);
							cover.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[15]);
							String str4 = str2.split(Pattern.quote(","))[16].replace("{", "").replace("}", "");
							cover.aspeedds.x = Float.parseFloat(str4.split(Pattern.quote(" "))[0].split(":")[1]);
							cover.aspeedds.y = Float.parseFloat(str4.split(Pattern.quote(" "))[1].split(":")[1]);
							String str5 = str2.split(Pattern.quote(","))[17];
							int idx1 = 0;
							while (true) {
								if (idx1 < str5.split("&").length - 1) {
									String str6 = str5.split("&")[idx1];
									Event _event = new Event(idx1);
									_event.tag = str6.split(Pattern.quote("|"))[0];
									_event.t = Integer.parseInt(str6.split(Pattern.quote("|"))[1]);
									_event.addtime = Integer.parseInt(str6.split(Pattern.quote("|"))[2]);
									int index3 = 0;
									while (true) {
										if (index3 < str6.split(Pattern.quote("|"))[3].split(";").length - 1) {
											_event.events.add(str6.split(Pattern.quote("|"))[3].split(";")[index3]);
											++index3;
										} else
											break;
									}
									cover.Parentevents.add(_event);
									++idx1;
								} else
									break;
							}
							String str7 = str2.split(Pattern.quote(","))[18];
							int idx2 = 0;
							while (true) {
								if (idx2 < str7.split("&").length - 1) {
									String str6 = str7.split("&")[idx2];
									Event _event = new Event(idx2);
									_event.tag = str6.split(Pattern.quote("|"))[0];
									_event.t = Integer.parseInt(str6.split(Pattern.quote("|"))[1]);
									_event.addtime = Integer.parseInt(str6.split(Pattern.quote("|"))[2]);
									int index3 = 0;
									while (true) {
										if (index3 < str6.split(Pattern.quote("|"))[3].split(";").length - 1) {
											_event.events.add(str6.split(Pattern.quote("|"))[3].split(";")[index3]);
											++index3;
										} else
											break;
									}
									cover.Sonevents.add(_event);
									++idx2;
								} else
									break;
							}
							cover.rand.speed = Float.parseFloat(str2.split(Pattern.quote(","))[19]);
							cover.rand.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[20]);
							cover.rand.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[21]);
							cover.rand.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[22]);
							if (str2.split(Pattern.quote(",")).length >= 24)
								cover.bindid = Integer.parseInt(str2.split(Pattern.quote(","))[23]);
							if (str2.split(Pattern.quote(",")).length >= 25) {
								if (!str2.split(Pattern.quote(","))[24].equals(""))
									cover.Deepbind = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[24]) ? 1 : 0) != 0;
							}
							Layer.LayerArray.get(index1).CoverArray.add(cover);
						}
						int num4 = Integer.parseInt(str1.split(":")[1].split(Pattern.quote(","))[6]);
						for (int index2 = 0;index2 < num4;++index2) {
							String str2 = streamReader.readLine();
							Rebound rebound = new Rebound(Float.parseFloat(str2.split(Pattern.quote(","))[2]), Float.parseFloat(str2.split(Pattern.quote(","))[3]), Layer.LayerArray.get(Layer.LayerArray.size() - Layer.selection - 1).color);
							rebound.id = Integer.parseInt(str2.split(Pattern.quote(","))[0]);
							rebound.parentid = Integer.parseInt(str2.split(Pattern.quote(","))[1]);
							rebound.begin = Integer.parseInt(str2.split(Pattern.quote(","))[4]);
							rebound.life = Integer.parseInt(str2.split(Pattern.quote(","))[5]);
							rebound.longs = Integer.parseInt(str2.split(Pattern.quote(","))[6]);
							rebound.angle = Integer.parseInt(str2.split(Pattern.quote(","))[7]);
							rebound.time = Integer.parseInt(str2.split(Pattern.quote(","))[8]);
							rebound.speed = Float.parseFloat(str2.split(Pattern.quote(","))[9]);
							rebound.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[10]);
							rebound.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[11]);
							rebound.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[12]);
							String str3 = str2.split(Pattern.quote(","))[13];
							int idx = 0;
							while (true) {
								if (idx < str3.split("&").length - 1) {
									String str4 = str3.split("&")[idx];
									Event e=new Event(idx);
									e.tag = str4;
									rebound.Parentevents.add(e);
									++idx;
								} else
									break;
							}
							rebound.rand.speed = Float.parseFloat(str2.split(Pattern.quote(","))[14]);
							rebound.rand.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[15]);
							rebound.rand.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[16]);
							rebound.rand.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[17]);
							Layer.LayerArray.get(index1).ReboundArray.add(rebound);
						}
						int num5 = Integer.parseInt(str1.split(":")[1].split(Pattern.quote(","))[7]);
						for (int index2 = 0;index2 < num5;++index2) {
							String str2 = streamReader.readLine();
							Force f= new Force(Float.parseFloat(str2.split(Pattern.quote(","))[2]), Float.parseFloat(str2.split(Pattern.quote(","))[3]), Layer.LayerArray.get(Layer.LayerArray.size() - Layer.selection - 1).color);
							f.id = Integer.parseInt(str2.split(Pattern.quote(","))[0]);
							f.parentid = Integer.parseInt(str2.split(Pattern.quote(","))[1]);
							f.begin = Integer.parseInt(str2.split(Pattern.quote(","))[4]);
							f.life = Integer.parseInt(str2.split(Pattern.quote(","))[5]);
							f.halfw = Integer.parseInt(str2.split(Pattern.quote(","))[6]);
							f.halfh = Integer.parseInt(str2.split(Pattern.quote(","))[7]);
							f.Circle = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[8]) ? 1 : 0) != 0;
							f.type = Integer.parseInt(str2.split(Pattern.quote(","))[9]);
							f.controlid = Integer.parseInt(str2.split(Pattern.quote(","))[10]);
							f.speed = Float.parseFloat(str2.split(Pattern.quote(","))[11]);
							f.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[12]);
							f.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[13]);
							f.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[14]);
							f.addaspeed = Float.parseFloat(str2.split(Pattern.quote(","))[15]);
							f.addaspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[16]);
							f.Suction = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[17]) ? 1 : 0) != 0;
							f.Repulsion = (Boolean.parseBoolean(str2.split(Pattern.quote(","))[18]) ? 1 : 0) != 0;
							f.addspeed = Float.parseFloat(str2.split(Pattern.quote(","))[19]);
							f.rand = new Force();
							f.rand.speed = Float.parseFloat(str2.split(Pattern.quote(","))[20]);
							f.rand.speedd = Float.parseFloat(str2.split(Pattern.quote(","))[21]);
							f.rand.aspeed = Float.parseFloat(str2.split(Pattern.quote(","))[22]);
							f.rand.aspeedd = Float.parseFloat(str2.split(Pattern.quote(","))[23]);
							Layer.LayerArray.get(index1).ForceArray.add(f);
						}
					}
				}
			}
		}
		streamReader.close();
	}
}
