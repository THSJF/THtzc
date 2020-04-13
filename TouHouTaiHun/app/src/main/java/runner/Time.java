package runner;
import java.util.*;
import java.util.regex.*;
import runner.layer.*;

public class Time {
        private static int clCount = 0;
        private static int clwait = 0;
        public static int total = 200;
        public static int now = 1;
        public static int left = 1;
        private static boolean search = false;
        private static int time = 0;
        public static float stop = 1f;
        public static boolean Playing = false;
        public static boolean Pause = false;
        public static ArrayList<GlobalEvent> GE = new ArrayList<>();
        public static ArrayList<Integer> GECount = new ArrayList<>();

        public static void Clear() {
            total=200;
            now=1;
            left=1;
            time=0;
            Playing=false;
            Pause=false;
            GE.clear();
            GECount.clear();
        }

        public static void Update() {
            if(Main.Available) {
                if(GE.size()<total) {
                    for(int index = 0;index<total-GE.size();++index) {
                        GlobalEvent g= new GlobalEvent();
						g.gotocondition=-1;
						g.quakecondition=-1;
						g.stopcondition=-1;
						g.stoplevel=-1;
                        GE.add(g);
                    }
                }
            }
            if(!Playing) {
                Playing=true;
                if(!Pause) {
                    for(Layer layer : Layer.LayerArray) {
                        for(Batch batch : layer.BatchArray) {
                            batch.copys=batch.Copy();
                            for(Event parentevent : batch.copys.Parentevents) {
                                parentevent.loop=0;
                            }
                            float num1 = MathHelper.Lerp(-batch.copys.rand.speed,batch.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-batch.copys.rand.speedd,batch.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-batch.copys.rand.aspeed,batch.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-batch.copys.rand.aspeedd,batch.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            if((double)batch.fx==-99998.0)
                                batch.copys.fx=batch.x-4f;
                            if((double)batch.fx==-99999.0)
                                batch.copys.fx=Player.position.x;
                            if((double)batch.fy==-99998.0)
                                batch.copys.fy=batch.y+16f;
                            if((double)batch.fy==-99999.0)
                                batch.copys.fy=Player.position.y;
                            if((double)batch.speedd==-99999.0)
                                batch.copys.speedd=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,batch.copys.fx,batch.copys.fy));
                            if((double)batch.aspeedd==-99999.0)
                                batch.copys.aspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,batch.copys.fx,batch.copys.fy));
                            batch.copys.aspeed+=num3;
                            batch.copys.aspeedd+=(float)num4;
                            batch.copys.speed+=num1;
                            batch.copys.speedd+=(float)num2;
                            batch.copys.aspeedx=batch.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(batch.copys.aspeedd));
                            batch.copys.aspeedy=batch.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(batch.copys.aspeedd));
                            batch.copys.speedx=batch.copys.speed*(float)Math.cos(MathHelper.ToRadians(batch.copys.speedd));
                            batch.copys.speedy=batch.copys.speed*(float)Math.sin(MathHelper.ToRadians(batch.copys.speedd));
                            batch.copys.bfdirection=batch.fdirection;
                            batch.copys.bsonaspeedd=batch.sonaspeedd;
                            if((double)batch.fdirection==-99998.0)
                                batch.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.x-4f,batch.y+16f,batch.copys.fx,batch.copys.fy));
                            else if((double)batch.fdirection==-99999.0)
                                batch.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,batch.copys.fx,batch.copys.fy));
                            else if((double)batch.fdirection==-100000.0)
                                batch.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.fdirections.x,batch.fdirections.y,batch.copys.fx,batch.copys.fy));
                            if((double)batch.sonaspeedd==-99998.0)
                                batch.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.x-4f,batch.y+16f,batch.copys.fx,batch.copys.fy));
                            else if((double)batch.sonaspeedd==-99999.0)
                                batch.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,batch.copys.fx,batch.copys.fy));
                            else if((double)batch.sonaspeedd==-100000.0)
                                batch.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.sonaspeedds.x,batch.sonaspeedds.y,batch.copys.fx,batch.copys.fy));
                            if((double)batch.head==-100000.0)
                                batch.copys.head=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.heads.x,batch.heads.y,batch.copys.fx,batch.copys.fx));
                            for(Event parentevent : batch.Parentevents) {
                                for(String str1 : parentevent.events) {
                                    String str2 = str1.split("：")[0];
                                    String str3 = "";
                                    String str4 = "";
                                    String str5 = "";
                                    String str6 = "";
                                    String str7 = "";
                                    String str8 = str1.split("：")[1];
                                    float num5 = 0.0f;
                                    int num6 = 0;
                                    if(str1.contains("且")) {
                                        str7="且";
                                        str3=str2.split("且")[1];
                                        str2=str2.split("且")[0];
                                    } else if(str1.contains("或")) {
                                        str7="或";
                                        str3=str2.split("或")[1];
                                        str2=str2.split("或")[0];
                                    }
                                    if(str2.contains(">")) {
                                        str4=str2.split(Pattern.quote(">"))[0];
                                        str5=">";
                                        str2=str2.split(Pattern.quote(">"))[1];
                                    }
                                    if(str2.contains("=")) {
                                        str4=str2.split(Pattern.quote("="))[0];
                                        str5="=";
                                        str2=str2.split(Pattern.quote("="))[1];
                                    }
                                    if(str2.contains("<")) {
                                        str4=str2.split(Pattern.quote("<"))[0];
                                        str5="<";
                                        str2=str2.split(Pattern.quote("<"))[1];
                                    }
                                    if(str3.contains(">")) {
                                        String str9 = str3.split(Pattern.quote(">"))[0];
                                        str6=">";
                                        str3=str3.split(Pattern.quote(">"))[1];
                                    }
                                    if(str3.contains("=")) {
                                        String str9 = str3.split(Pattern.quote("="))[0];
                                        str6="=";
                                        str3=str3.split(Pattern.quote("="))[1];
                                    }
                                    if(str3.contains("<")) {
                                        String str9 = str3.split(Pattern.quote("<"))[0];
                                        str6="<";
                                        str3=str3.split(Pattern.quote("<"))[1];
                                    }
                                    if(str1.contains("变化到")) {
                                        int num7 = 0;
                                        String[] strArray = str8.split("变")[1].split("，");
                                        int result = Main.results.get(str8.split("变")[0]);
                                        String str9 = str8.split("变")[0];
                                        if(strArray[0].replace("化到","").contains("+")) {
                                            if(strArray[0].replace("化到","").split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].replace("化到","").split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].replace("化到","").split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].replace("化到","").equals("自身"))
                                            num6=3;
                                        else if(strArray[0].replace("化到","").equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0].replace("化到",""));
                                        String str10 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str8;
										eventRead.condition2=str3;
										eventRead.contype=Main.conditions.get(str4);
										eventRead.contype2=Main.conditions.get(str4);
										eventRead.opreator=str5;
										eventRead.opreator2=str6;
										eventRead.collector=str7;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str10);
										eventRead.changevalue=result;
										eventRead.changename=Main.results.get(str9);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].replace("化到","").contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].replace("化到","").split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    } else if(str1.contains("增加")) {
                                        int num7 = 1;
                                        String[] strArray = str8.split("增")[1].split("，");
                                        strArray[0]=strArray[0].replace("加","");
                                        int result = Main.results.get(str8.split("增")[0]);
                                        String str9 = str8.split("增")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自身"))
                                            num6=3;
                                        else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str10 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
                                            eventRead.condition=str2;
                                            eventRead.result=str8;
                                            eventRead.condition2=str3;
                                            eventRead.contype=Main.conditions.get(str4);
                                            eventRead.contype2=Main.conditions.get(str4);
                                            eventRead.opreator=str5;
                                            eventRead.opreator2=str6;
                                            eventRead.collector=str7;
                                            eventRead.change=num7;
                                            eventRead.changetype=Main.type.get(str10);
                                            eventRead.changevalue=result;
                                           eventRead.changename=Main.results.get(str9);
                                            eventRead.res=num5;
                                            eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    } else if(str1.contains("减少")) {
                                        int num7 = 2;
                                        String[] strArray = str8.split("减少")[1].split("，");
                                        int result = Main.results.get(str8.split("减少")[0]);
                                        String str9 = str8.split("减少")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自身"))
                                            num6=3;
                                        else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str10 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
                                            eventRead.condition=str2;
                                            eventRead.result=str8;
                                            eventRead.condition2=str3;
                                            eventRead.contype=Main.conditions.get(str4);
                                            eventRead.contype2=Main.conditions.get(str4);
                                            eventRead.opreator=str5;
                                            eventRead.opreator2=str6;
                                            eventRead.collector=str7;
                                            eventRead.change=num7;
                                            eventRead.changetype=Main.type.get(str10);
                                            eventRead.changevalue=result;
                                            eventRead.changename=Main.results.get(str9);
                                            eventRead.res=num5;
                                            eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    } else if(str1.contains("恢复")){
										EventRead e=new EventRead();
										e.special=1;
										e.opreator=str5;
										e.opreator2=str6;
										e.condition=str2;
										e.condition2=str3;
										e.contype=Main.conditions.get(str4);
										e.contype2=Main.conditions.get(str4);
										e.collector=str7;
                                        parentevent.results.add(e);
									} else if(str1.contains("发射")){
                                        EventRead e=new EventRead();
										e.special=2;
										e.opreator=str5;
										e.opreator2=str6;
										e.condition=str2;
										e.condition2=str3;
										e.contype=Main.conditions.get(str4);
										e.contype2=Main.conditions.get(str4);
										e.collector=str7;
										parentevent.results.add(e);
									}
                                }
                            }
                            for(Event sonevent : batch.Sonevents) {
                                for(String str1 : sonevent.events) {
                                    String str2 = str1.split("：")[0];
                                    String str3 = "";
                                    String str4 = "";
                                    String str5 = "";
                                    String str6 = "";
                                    String str7 = "";
                                    String str8 = "";
                                    String str9 = str1.split("：")[1];
                                    float num5 = 0.0f;
                                    int num6 = 0;
                                    if(str1.contains("且")) {
                                        str8="且";
                                        str3=str2.split("且")[1];
                                        str2=str2.split("且")[0];
                                    } else if(str1.contains("或")) {
                                        str8="或";
                                        str3=str2.split("或")[1];
                                        str2=str2.split("或")[0];
                                    }
                                    if(str2.contains(">")) {
                                        str4=str2.split(Pattern.quote(">"))[0];
                                        str6=">";
                                        str2=str2.split(Pattern.quote(">"))[1];
                                    }
                                    if(str2.contains("=")) {
                                        str4=str2.split(Pattern.quote("="))[0];
                                        str6="=";
                                        str2=str2.split(Pattern.quote("="))[1];
                                    }
                                    if(str2.contains("<")) {
                                        str4=str2.split(Pattern.quote("<"))[0];
                                        str6="<";
                                        str2=str2.split(Pattern.quote("<"))[1];
                                    }
                                    if(str3.contains(">")) {
                                        str5=str3.split(Pattern.quote(">"))[0];
                                        str7=">";
                                        str3=str3.split(Pattern.quote(">"))[1];
                                    }
                                    if(str3.contains("=")) {
                                        str5=str3.split(Pattern.quote("="))[0];
                                        str7="=";
                                        str3=str3.split(Pattern.quote("="))[1];
                                    }
                                    if(str3.contains("<")) {
                                        str5=str3.split(Pattern.quote("<"))[0];
                                        str7="<";
                                        str3=str3.split(Pattern.quote("<"))[1];
                                    }
                                    if(str1.contains("变化到")) {
                                        int num7 = 0;
                                        String[] strArray = str9.split("变")[1].split("，");
                                        int num8 = Main.results2.get(str9.split("变")[0]);
                                        String str10 = str9.split("变")[0];
                                        if(strArray[0].replace("化到","").contains("+")) {
                                            if(strArray[0].replace("化到","").split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].replace("化到","").split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].replace("化到","").split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].replace("化到","").split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].replace("化到","").equals("自身"))
                                            num6=3;
                                        else if(strArray[0].replace("化到","").equals("自机"))
                                            num6=4;
                                        else if(strArray[0].replace("化到","").equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0].replace("化到",""));
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.conditions2.get(str4);
										eventRead.contype2=Main.conditions2.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=num8;
										eventRead.changename=Main.results2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].replace("化到","").contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].replace("化到","").split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    } else if(str1.contains("增加")) {
                                        int num7 = 1;
                                        String[] strArray = str9.split("增")[1].split("，");
                                        strArray[0]=strArray[0].replace("加","");
                                        int num8 = Main.results2.get(str9.split("增")[0]);
                                        String str10 = str9.split("增")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自身"))
                                            num6=3;
                                        else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else if(strArray[0].equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.conditions2.get(str4);
										eventRead.contype2=Main.conditions2.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=num8;
										eventRead.changename=Main.results2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    } else if(str1.contains("减少")) {
                                        int num7 = 2;
                                        String[] strArray = str9.split("减少")[2].split("，");
                                        int num8 = Main.results2.get(str9.split("减少")[0]);
                                        String str10 = str9.split("减少")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自身"))
                                            num6=3;
                                        else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else if(strArray[0].equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.conditions2.get(str4);
										eventRead.contype2=Main.conditions2.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=num8;
										eventRead.changename=Main.results2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    }
                                }
                            }
                        }
                        for(Lase lase : layer.LaseArray) {
                            lase.copys=lase.Copy();
                            for(Event parentevent : lase.copys.Parentevents)
                                parentevent.loop=0;
                            float num1 = MathHelper.Lerp(-lase.copys.rand.speed,lase.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-lase.copys.rand.speedd,lase.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-lase.copys.rand.aspeed,lase.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-lase.copys.rand.aspeedd,lase.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            lase.copys.aspeed+=num3;
                            lase.copys.aspeedd+=(float)num4;
                            lase.copys.speed+=num1;
                            lase.copys.speedd+=(float)num2;
                            lase.copys.aspeedx=lase.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(lase.copys.aspeedd));
                            lase.copys.aspeedy=lase.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(lase.copys.aspeedd));
                            lase.copys.speedx=lase.copys.speed*(float)Math.cos(MathHelper.ToRadians(lase.copys.speedd));
                            lase.copys.speedy=lase.copys.speed*(float)Math.sin(MathHelper.ToRadians(lase.copys.speedd));
                            if((double)lase.fdirection==-99999.0)
                                lase.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,lase.copys.x-4f,lase.copys.y+16f));
                            else if((double)lase.fdirection==-100000.0)
                                lase.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(lase.fdirections.x,lase.fdirections.y,lase.copys.x-4f,lase.copys.y+16f));
                            if((double)lase.sonaspeedd==-99998.0)
                                lase.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(lase.x-4f,lase.y+16f,lase.copys.x-4f,lase.copys.y+16f));
                            else if((double)lase.sonaspeedd==-99999.0)
                                lase.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,lase.copys.x-4f,lase.copys.y+16f));
                            else if((double)lase.sonaspeedd==-100000.0)
                                lase.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(lase.sonaspeedds.x,lase.sonaspeedds.y,lase.copys.x-4f,lase.copys.y+16f));
                            for(Event parentevent : lase.Parentevents) {
                                for(String str1 : parentevent.events) {
                                    String str2 = str1.split("：")[0];
                                    String str3 = "";
                                    String str4 = "";
                                    String str5 = "";
                                    String str6 = "";
                                    String str7 = "";
                                    String str8 = "";
                                    String str9 = str1.split("：")[1];
                                    float num5 = 0.0f;
                                    int num6 = 0;
                                    if(str1.contains("且")) {
                                        str8="且";
                                        str3=str2.split("且")[1];
                                        str2=str2.split("且")[0];
                                    } else if(str1.contains("或")) {
                                        str8="或";
                                        str3=str2.split("或")[1];
                                        str2=str2.split("或")[0];
                                    }
                                    if(str2.contains(">")) {
                                        str4=str2.split(Pattern.quote(">"))[0];
                                        str6=">";
                                        str2=str2.split(Pattern.quote(">"))[1];
                                    }
                                    if(str2.contains("=")) {
                                        str4=str2.split(Pattern.quote("="))[0];
                                        str6="=";
                                        str2=str2.split(Pattern.quote("="))[1];
                                    }
                                    if(str2.contains("<")) {
                                        str4=str2.split(Pattern.quote("<"))[0];
                                        str6="<";
                                        str2=str2.split(Pattern.quote("<"))[1];
                                    }
                                    if(str3.contains(">")) {
                                        str5=str3.split(Pattern.quote(">"))[0];
                                        str7=">";
                                        str3=str3.split(Pattern.quote(">"))[1];
                                    }
                                    if(str3.contains("=")) {
                                        str5=str3.split(Pattern.quote("="))[0];
                                        str7="=";
                                        str3=str3.split(Pattern.quote("="))[1];
                                    }
                                    if(str3.contains("<")) {
                                        str5=str3.split(Pattern.quote("<"))[0];
                                        str7="<";
                                        str3=str3.split(Pattern.quote("<"))[1];
                                    }
                                    if(str1.contains("变化到")) {
                                        int num7 = 0;
                                        String[] strArray = str9.split("变化到")[3].split("，");
                                        int lresult = Main.lresults.get(str9.split("变化到")[0]);
                                        String str10 = str9.split("变化到")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.lconditions.get(str4);
										eventRead.contype2=Main.lconditions.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=lresult;
										eventRead.changename=Main.lresults.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    } else if(str1.contains("增加")) {
                                        int num7 = 1;
                                        String[] strArray = str9.split("增")[1].split("，");
                                        strArray[0]=strArray[0].replace("加","");
                                        int lresult = Main.lresults.get(str9.split("增")[0]);
                                        String str10 = str9.split("增")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.lconditions.get(str4);
										eventRead.contype2=Main.lconditions.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=lresult;
										eventRead.changename=Main.lresults.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    } else if(str1.contains("减少")) {
                                        int num7 = 2;
                                        String[] strArray = str9.split("减少")[2].split("，");
                                        int lresult = Main.lresults.get(str9.split("减少")[0]);
                                        String str10 = str9.split("减少")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.lconditions.get(str4);
										eventRead.contype2=Main.lconditions.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=lresult;
										eventRead.changename=Main.lresults.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    } else if(str1.contains("恢复")){
										EventRead e=new EventRead();
										e.special=1;
										e.opreator=str6;
										e.opreator2=str7;
										e.condition=str2;
										e.condition2=str3;
										e.contype=Main.lconditions.get(str4);
										e.contype2=Main.lconditions.get(str5);
										e.collector=str8;
                                        parentevent.results.add(e);
									} else if(str1.contains("发射")){
										EventRead e=new EventRead();
										e.special=2;
										e.opreator=str6;
										e.opreator2=str7;
										e.condition=str2;
										e.condition2=str3;
										e.contype=Main.lconditions.get(str4);
										e.contype2=Main.lconditions.get(str5);
										e.collector=str8;
										parentevent.results.add(e);
									}
                                }
                            }
                            for(Event sonevent : lase.Sonevents) {
                                for(String str1 : sonevent.events) {
                                    String str2 = str1.split("：")[0];
                                    String str3 = "";
                                    String str4 = "";
                                    String str5 = "";
                                    String str6 = "";
                                    String str7 = "";
                                    String str8 = "";
                                    String str9 = str1.split("：")[1];
                                    float num5 = 0.0f;
                                    int num6 = 0;
                                    if(str1.contains("且")) {
                                        str8="且";
                                        str3=str2.split("且")[1];
                                        str2=str2.split("且")[0];
                                    } else if(str1.contains("或")) {
                                        str8="或";
                                        str3=str2.split("或")[1];
                                        str2=str2.split("或")[0];
                                    }
                                    if(str2.contains(">")) {
                                        str4=str2.split(Pattern.quote(">"))[0];
                                        str6=">";
                                        str2=str2.split(Pattern.quote(">"))[1];
                                    }
                                    if(str2.contains("=")) {
                                        str4=str2.split(Pattern.quote("="))[0];
                                        str6="=";
                                        str2=str2.split(Pattern.quote("="))[1];
                                    }
                                    if(str2.contains("<")) {
                                        str4=str2.split(Pattern.quote("<"))[0];
                                        str6="<";
                                        str2=str2.split(Pattern.quote("<"))[1];
                                    }
                                    if(str3.contains(">")) {
                                        str5=str3.split(Pattern.quote(">"))[0];
                                        str7=">";
                                        str3=str3.split(Pattern.quote(">"))[1];
                                    }
                                    if(str3.contains("=")) {
                                        str5=str3.split(Pattern.quote("="))[0];
                                        str7="=";
                                        str3=str3.split(Pattern.quote("="))[1];
                                    }
                                    if(str3.contains("<")) {
                                        str5=str3.split(Pattern.quote("<"))[0];
                                        str7="<";
                                        str3=str3.split(Pattern.quote("<"))[1];
                                    }
                                    if(str1.contains("变化到")) {
                                        int num7 = 0;
                                        String[] strArray = str9.split("变化到")[3].split("，");
                                        int num8 = Main.lresults2.get(str9.split("变化到")[0]);
                                        String str10 = str9.split("变化到")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else if(strArray[0].equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.lconditions.get(str4);
										eventRead.contype2=Main.lconditions.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=num8;
										eventRead.changename=Main.lresults2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    } else if(str1.contains("增加")) {
                                        int num7 = 1;
                                        String[] strArray = str9.split("增")[1].split("，");
                                        strArray[0]=strArray[0].replace("加","");
                                        int num8 = Main.lresults2.get(str9.split("增")[0]);
                                        String str10 = str9.split("增")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else if(strArray[0].equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.lconditions.get(str4);
										eventRead.contype2=Main.lconditions.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=num8;
										eventRead.changename=Main.lresults2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    } else if(str1.contains("减少")) {
                                        int num7 = 2;
                                        String[] strArray = str9.split("减少")[2].split("，");
                                        int num8 = Main.lresults2.get(str9.split("减少")[0]);
                                        String str10 = str9.split("减少")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else if(strArray[0].equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
                                        eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
                                        eventRead.contype=Main.lconditions.get(str4);
										eventRead.contype2=Main.lconditions.get(str5);
                                        eventRead.opreator=str6;
                                        eventRead.opreator2=str7;
                                        eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
                                        eventRead.changevalue=num8;
										eventRead.changename=Main.lresults2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    }
                                }
                            }
                        }
                        for(Cover cover : layer.CoverArray) {
                            cover.copys=cover.Copy();
                            for(Event parentevent : cover.copys.Parentevents)
                                parentevent.loop=0;
                            float num1 = MathHelper.Lerp(-cover.copys.rand.speed,cover.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-cover.copys.rand.speedd,cover.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-cover.copys.rand.aspeed,cover.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-cover.copys.rand.aspeedd,cover.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            cover.copys.aspeed+=num3;
                            cover.copys.aspeedd+=(float)num4;
                            cover.copys.speed+=num1;
                            cover.copys.speedd+=(float)num2;
                            cover.copys.aspeedx=cover.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(cover.copys.aspeedd));
                            cover.copys.aspeedy=cover.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(cover.copys.aspeedd));
                            cover.copys.speedx=cover.copys.speed*(float)Math.cos(MathHelper.ToRadians(cover.copys.speedd));
                            cover.copys.speedy=cover.copys.speed*(float)Math.sin(MathHelper.ToRadians(cover.copys.speedd));
                            for(Event parentevent : cover.Parentevents) {
                                for(String str1 : parentevent.events) {
                                    String str2 = str1.split("：")[0];
                                    String str3 = "";
                                    String str4 = "";
                                    String str5 = "";
                                    String str6 = "";
                                    String str7 = "";
                                    String str8 = "";
                                    String str9 = str1.split("：")[1];
                                    float num5 = 0.0f;
                                    int num6 = 0;
                                    if(str1.contains("且")) {
                                        str8="且";
                                        str3=str2.split("且")[1];
                                        str2=str2.split("且")[0];
                                    } else if(str1.contains("或")) {
                                        str8="或";
                                        str3=str2.split("或")[1];
                                        str2=str2.split("或")[0];
                                    }
                                    if(str2.contains(">")) {
                                        str4=str2.split(Pattern.quote(">"))[0];
                                        str6=">";
                                        str2=str2.split(Pattern.quote(">"))[1];
                                    }
                                    if(str2.contains("=")) {
                                        str4=str2.split(Pattern.quote("="))[0];
                                        str6="=";
                                        str2=str2.split(Pattern.quote("="))[1];
                                    }
                                    if(str2.contains("<")) {
                                        str4=str2.split(Pattern.quote("<"))[0];
                                        str6="<";
                                        str2=str2.split(Pattern.quote("<"))[1];
                                    }
                                    if(str3.contains(">")) {
                                        str5=str3.split(Pattern.quote(">"))[0];
                                        str7=">";
                                        str3=str3.split(Pattern.quote(">"))[1];
                                    }
                                    if(str3.contains("=")) {
                                        str5=str3.split(Pattern.quote("="))[0];
                                        str7="=";
                                        str3=str3.split(Pattern.quote("="))[1];
                                    }
                                    if(str3.contains("<")) {
                                        str5=str3.split(Pattern.quote("<"))[0];
                                        str7="<";
                                        str3=str3.split(Pattern.quote("<"))[1];
                                    }
                                    if(str1.contains("变化到")) {
                                        int num7 = 0;
                                        String[] strArray = str9.split("变化到")[3].split("，");
                                        int cresult = Main.cresults.get(str9.split("变化到")[0]);
                                        String str10 = str9.split("变化到")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
										EventRead eventRead = new EventRead();
										eventRead.condition=str2;
                                        eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.cconditions.get(str4);
										eventRead.contype2=Main.cconditions.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=cresult;
										eventRead.changename=Main.cresults.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
										if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    } else if(str1.contains("增加")) {
                                        int num7 = 1;
                                        String[] strArray = str9.split("增")[1].split("，");
                                        strArray[0]=strArray[0].replace("加","");
                                        int cresult = Main.cresults.get(str9.split("增")[0]);
                                        String str10 = str9.split("增")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.cconditions.get(str4);
										eventRead.contype2=Main.cconditions.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=cresult;
										eventRead.changename=Main.cresults.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    } else if(str1.contains("减少")) {
                                        int num7 = 2;
                                        String[] strArray = str9.split("减少")[2].split("，");
                                        int cresult = Main.cresults.get(str9.split("减少")[0]);
                                        String str10 = str9.split("减少")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num8 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.cconditions.get(str4);
										eventRead.contype2=Main.cconditions.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=cresult;
										eventRead.changename=Main.cresults.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num8;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        parentevent.results.add(eventRead);
                                    }
                                }
                            }
                            for(Event sonevent : cover.Sonevents) {
                                for(String str1 : sonevent.events) {
                                    String str2 = str1.split("：")[0];
                                    String str3 = "";
                                    String str4 = "";
                                    String str5 = "";
                                    String str6 = "";
                                    String str7 = "";
                                    String str8 = "";
                                    String str9 = str1.split("：")[1];
                                    float num5 = 0.0f;
                                    int num6 = 0;
                                    if(str1.contains("且")) {
                                        str8="且";
                                        str3=str2.split("且")[1];
                                        str2=str2.split("且")[0];
                                    } else if(str1.contains("或")) {
                                        str8="或";
                                        str3=str2.split("或")[1];
                                        str2=str2.split("或")[0];
                                    }
                                    if(str2.contains(">")) {
                                        str4=str2.split(Pattern.quote(">"))[0];
                                        str6=">";
                                        str2=str2.split(Pattern.quote(">"))[1];
                                    }
                                    if(str2.contains("=")) {
                                        str4=str2.split(Pattern.quote("="))[0];
                                        str6="=";
                                        str2=str2.split(Pattern.quote("="))[1];
                                    }
                                    if(str2.contains("<")) {
                                        str4=str2.split(Pattern.quote("<"))[0];
                                        str6="<";
                                        str2=str2.split(Pattern.quote("<"))[1];
                                    }
                                    if(str3.contains(">")) {
                                        str5=str3.split(Pattern.quote(">"))[0];
                                        str7=">";
                                        str3=str3.split(Pattern.quote(">"))[1];
                                    }
                                    if(str3.contains("=")) {
                                        str5=str3.split(Pattern.quote("="))[0];
                                        str7="=";
                                        str3=str3.split(Pattern.quote("="))[1];
                                    }
                                    if(str3.contains("<")) {
                                        str5=str3.split(Pattern.quote("<"))[0];
                                        str7="<";
                                        str3=str3.split(Pattern.quote("<"))[1];
                                    }
                                    if(str1.contains("变化到")) {
                                        int num7 = 0;
                                        String[] strArray = str9.split("变化到")[3].split("，");
                                        int num8 = Main.results2.get(str9.split("变化到")[0]);
                                        String str10 = str9.split("变化到")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自身"))
                                            num6=3;
                                        else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else if(strArray[0].equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.conditions2.get(str4);
										eventRead.contype2=Main.conditions2.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=num8;
										eventRead.changename=Main.results2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
										eventRead.special2=1;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    } else if(str1.contains("增加")) {
                                        int num7 = 1;
                                        String[] strArray = str9.split("增")[1].split("，");
                                        strArray[0]=strArray[0].replace("加","");
                                        int num8 = Main.results2.get(str9.split("增")[0]);
                                        String str10 = str9.split("增")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自身"))
                                            num6=3;
                                        else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else if(strArray[0].equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.conditions2.get(str4);
										eventRead.contype2=Main.conditions2.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=num8;
										eventRead.changename=Main.results2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
										eventRead.special2=1;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    } else if(str1.contains("减少")) {
                                        int num7 = 2;
                                        String[] strArray = str9.split("减少")[2].split("，");
                                        int num8 = Main.results2.get(str9.split("减少")[0]);
                                        String str10 = str9.split("减少")[0];
                                        if(strArray[0].contains("+")) {
                                            if(strArray[0].split(Pattern.quote("+"))[0].equals("自身"))
                                                num6=3;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("自机"))
                                                num6=4;
                                            else if(strArray[0].split(Pattern.quote("+"))[0].equals("中心")) {
                                                num6=5;
                                                str6="";
                                            } else
                                                num5=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[0]);
                                        } else if(strArray[0].equals("自身"))
                                            num6=3;
                                        else if(strArray[0].equals("自机"))
                                            num6=4;
                                        else if(strArray[0].equals("中心")) {
                                            num6=5;
                                            str6="";
                                        } else
                                            num5=Float.parseFloat(strArray[0]);
                                        String str11 = strArray[1];
                                        int num9 = Integer.parseInt(strArray[2].split("帧")[0]);
                                        EventRead eventRead = new EventRead();
										eventRead.condition=str2;
										eventRead.result=str9;
										eventRead.condition2=str3;
										eventRead.contype=Main.conditions2.get(str4);
										eventRead.contype2=Main.conditions2.get(str5);
										eventRead.opreator=str6;
										eventRead.opreator2=str7;
										eventRead.collector=str8;
										eventRead.change=num7;
										eventRead.changetype=Main.type.get(str11);
										eventRead.changevalue=num8;
										eventRead.changename=Main.results2.get(str10);
										eventRead.res=num5;
										eventRead.special=num6;
										eventRead.special2=1;
                                        if(strArray[0].contains("+"))
                                            eventRead.rand=Float.parseFloat(strArray[0].split(Pattern.quote("+"))[1]);
                                        eventRead.times=num9;
                                        if(strArray[2].contains("("))
                                            eventRead.time=Integer.parseInt(strArray[2].split(Pattern.quote("("))[1].split(Pattern.quote(")"))[0]);
                                        sonevent.results.add(eventRead);
                                    }
                                }
                            }
                        }
                        for(Rebound rebound : layer.ReboundArray) {
                            rebound.copys=rebound.Copy();
                            float num1 = MathHelper.Lerp(-rebound.copys.rand.speed,rebound.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-rebound.copys.rand.speedd,rebound.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-rebound.copys.rand.aspeed,rebound.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-rebound.copys.rand.aspeedd,rebound.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            rebound.copys.aspeed+=num3;
                            rebound.copys.aspeedd+=(float)num4;
                            rebound.copys.speed+=num1;
                            rebound.copys.speedd+=(float)num2;
                            rebound.copys.aspeedx=rebound.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(rebound.copys.aspeedd));
                            rebound.copys.aspeedy=rebound.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(rebound.copys.aspeedd));
                            rebound.copys.speedx=rebound.copys.speed*(float)Math.cos(MathHelper.ToRadians(rebound.copys.speedd));
                            rebound.copys.speedy=rebound.copys.speed*(float)Math.sin(MathHelper.ToRadians(rebound.copys.speedd));
                        }
                        for(Force force : layer.ForceArray) {
                            force.copys=force.Copy();
                            float num1 = MathHelper.Lerp(-force.copys.rand.speed,force.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-force.copys.rand.speedd,force.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-force.copys.rand.aspeed,force.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-force.copys.rand.aspeedd,force.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            force.copys.aspeed+=num3;
                            force.copys.aspeedd+=(float)num4;
                            force.copys.speed+=num1;
                            force.copys.speedd+=(float)num2;
                            force.copys.aspeedx=force.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(force.copys.aspeedd));
                            force.copys.aspeedy=force.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(force.copys.aspeedd));
                            force.copys.speedx=force.copys.speed*(float)Math.cos(MathHelper.ToRadians(force.copys.speedd));
                            force.copys.speedy=force.copys.speed*(float)Math.sin(MathHelper.ToRadians(force.copys.speedd));
                        }
                    }
                    int now = Time.now;
                    Time.now=1;
                    for(int index = 0;index<now;++index) {
                        for(Layer layer : Layer.LayerArray) {
                            for(Batch batch : layer.BatchArray)
                                batch.copys.PreviewUpdate();
                        }
                        ++Time.now;
                    }
                    Time.now=1;
                    for(int index = 0;index<now;++index) {
                        for(Layer layer : Layer.LayerArray) {
                            for(Lase lase : layer.LaseArray)
                                lase.copys.PreviewUpdate();
                        }
                        ++Time.now;
                    }
                    Time.now=1;
                    for(int index = 0;index<now;++index) {
                        for(Layer layer : Layer.LayerArray) {
                            for(Cover cover : layer.CoverArray)
                                cover.copys.PreviewUpdate();
                        }
                        ++Time.now;
                    }
                    Time.now=1;
                    for(int index = 0;index<now;++index) {
                        for(Layer layer : Layer.LayerArray) {
                            for(Rebound rebound : layer.ReboundArray)
                                rebound.copys.PreviewUpdate();
                        }
                        ++Time.now;
                    }
                    Time.now=1;
                    for(int index = 0;index<now;++index) {
                        for(Layer layer : Layer.LayerArray) {
                            for(Force force : layer.ForceArray)
                                force.copys.PreviewUpdate();
                        }
                        ++Time.now;
                    }
                    Time.now=now-1;
                }
            }
            if(Time.Playing) {
                ++Time.now;
                if(Time.now>Time.total) {
                    Time.now=1;
                    Time.left=1;
                    Center.Eventsexe.clear();
                    for(Layer layer : Layer.LayerArray) {
                        for(Batch batch : layer.BatchArray) {
                            batch.Eventsexe.clear();
                            batch.copys=batch.Copy();
                            for(Event parentevent : batch.copys.Parentevents)
                                parentevent.loop=0;
                            float num1 = MathHelper.Lerp(-batch.copys.rand.speed,batch.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-batch.copys.rand.speedd,batch.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-batch.copys.rand.aspeed,batch.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-batch.copys.rand.aspeedd,batch.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            if((double)batch.fx==-99998.0)
                                batch.copys.fx=batch.x-4f;
                            if((double)batch.fx==-99999.0)
                                batch.copys.fx=Player.position.x;
                            if((double)batch.fy==-99998.0)
                                batch.copys.fy=batch.y+16f;
                            if((double)batch.fy==-99999.0)
                                batch.copys.fy=Player.position.y;
                            if((double)batch.speedd==-99999.0)
                                batch.copys.speedd=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,batch.copys.fx,batch.copys.fy));
                            if((double)batch.aspeedd==-99999.0)
                                batch.copys.aspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,batch.copys.fx,batch.copys.fy));
                            batch.copys.aspeed+=num3;
                            batch.copys.aspeedd+=(float)num4;
                            batch.copys.speed+=num1;
                            batch.copys.speedd+=(float)num2;
                            batch.copys.aspeedx=batch.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(batch.copys.aspeedd));
                            batch.copys.aspeedy=batch.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(batch.copys.aspeedd));
                            batch.copys.speedx=batch.copys.speed*(float)Math.cos(MathHelper.ToRadians(batch.copys.speedd));
                            batch.copys.speedy=batch.copys.speed*(float)Math.sin(MathHelper.ToRadians(batch.copys.speedd));
                            batch.copys.bfdirection=batch.fdirection;
                            batch.copys.bsonaspeedd=batch.sonaspeedd;
                            if((double)batch.fdirection==-99998.0)
                                batch.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.x-4f,batch.y+16f,batch.copys.fx,batch.copys.fy));
                            else if((double)batch.fdirection==-99999.0)
                                batch.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,batch.copys.fx,batch.copys.fy));
                            else if((double)batch.fdirection==-100000.0)
                                batch.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.fdirections.x,batch.fdirections.y,batch.copys.fx,batch.copys.fy));
                            if((double)batch.sonaspeedd==-99998.0)
                                batch.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.x-4f,batch.y+16f,batch.copys.fx,batch.copys.fy));
                            else if((double)batch.sonaspeedd==-99999.0)
                                batch.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,batch.copys.fx,batch.copys.fy));
                            else if((double)batch.sonaspeedd==-100000.0)
                                batch.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.sonaspeedds.x,batch.sonaspeedds.y,batch.copys.fx,batch.copys.fy));
                            if((double)batch.head==-100000.0)
                                batch.copys.head=(float)MathHelper.ToDegrees(Main.Twopointangle(batch.heads.x,batch.heads.y,batch.copys.fx,batch.copys.fx));
                        }
                        for(Lase lase : layer.LaseArray) {
                            lase.Eventsexe.clear();
                            lase.copys=lase.Copy();
                            for(Event parentevent : lase.copys.Parentevents)
                                parentevent.loop=0;
                            float num1 = MathHelper.Lerp(-lase.copys.rand.speed,lase.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-lase.copys.rand.speedd,lase.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-lase.copys.rand.aspeed,lase.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-lase.copys.rand.aspeedd,lase.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            lase.copys.aspeed+=num3;
                            lase.copys.aspeedd+=(float)num4;
                            lase.copys.speed+=num1;
                            lase.copys.speedd+=(float)num2;
                            lase.copys.aspeedx=lase.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(lase.copys.aspeedd));
                            lase.copys.aspeedy=lase.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(lase.copys.aspeedd));
                            lase.copys.speedx=lase.copys.speed*(float)Math.cos(MathHelper.ToRadians(lase.copys.speedd));
                            lase.copys.speedy=lase.copys.speed*(float)Math.sin(MathHelper.ToRadians(lase.copys.speedd));
                            if((double)lase.fdirection==-99999.0)
                                lase.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,lase.copys.x-4f,lase.copys.y+16f));
                            else if((double)lase.fdirection==-100000.0)
                                lase.copys.fdirection=(float)MathHelper.ToDegrees(Main.Twopointangle(lase.fdirections.x,lase.fdirections.y,lase.copys.x-4f,lase.copys.y+16f));
                            if((double)lase.sonaspeedd==-99998.0)
                                lase.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(lase.x-4f,lase.y+16f,lase.copys.x-4f,lase.copys.y+16f));
                            else if((double)lase.sonaspeedd==-99999.0)
                                lase.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(Player.position.x,Player.position.y,lase.copys.x-4f,lase.copys.y+16f));
                            else if((double)lase.sonaspeedd==-100000.0)
                                lase.copys.sonaspeedd=(float)MathHelper.ToDegrees(Main.Twopointangle(lase.sonaspeedds.x,lase.sonaspeedds.y,lase.copys.x-4f,lase.copys.y+16f));
                        }
                        for(Cover cover : layer.CoverArray) {
                            cover.Eventsexe.clear();
                            cover.copys=cover.Copy();
                            for(Event parentevent : cover.copys.Parentevents)
                                parentevent.loop=0;
                            float num1 = MathHelper.Lerp(-cover.copys.rand.speed,cover.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-cover.copys.rand.speedd,cover.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-cover.copys.rand.aspeed,cover.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-cover.copys.rand.aspeedd,cover.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            cover.copys.aspeed+=num3;
                            cover.copys.aspeedd+=(float)num4;
                            cover.copys.speed+=num1;
                            cover.copys.speedd+=(float)num2;
                            cover.copys.aspeedx=cover.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(cover.copys.aspeedd));
                            cover.copys.aspeedy=cover.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(cover.copys.aspeedd));
                            cover.copys.speedx=cover.copys.speed*(float)Math.cos(MathHelper.ToRadians(cover.copys.speedd));
                            cover.copys.speedy=cover.copys.speed*(float)Math.sin(MathHelper.ToRadians(cover.copys.speedd));
                        }
                        for(Rebound rebound : layer.ReboundArray) {
                            rebound.copys=rebound.Copy();
                            float num1 = MathHelper.Lerp(-rebound.copys.rand.speed,rebound.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-rebound.copys.rand.speedd,rebound.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-rebound.copys.rand.aspeed,rebound.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-rebound.copys.rand.aspeedd,rebound.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            rebound.copys.aspeed+=num3;
                            rebound.copys.aspeedd+=(float)num4;
                            rebound.copys.speed+=num1;
                            rebound.copys.speedd+=(float)num2;
                            rebound.copys.aspeedx=rebound.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(rebound.copys.aspeedd));
                            rebound.copys.aspeedy=rebound.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(rebound.copys.aspeedd));
                            rebound.copys.speedx=rebound.copys.speed*(float)Math.cos(MathHelper.ToRadians(rebound.copys.speedd));
                            rebound.copys.speedy=rebound.copys.speed*(float)Math.sin(MathHelper.ToRadians(rebound.copys.speedd));
                        }
                        for(Force force : layer.ForceArray) {
                            force.copys=force.Copy();
                            float num1 = MathHelper.Lerp(-force.copys.rand.speed,force.copys.rand.speed,(float)Main.rand.nextDouble());
                            int num2 = (int) MathHelper.Lerp(-force.copys.rand.speedd,force.copys.rand.speedd,(float)Main.rand.nextDouble());
                            float num3 = MathHelper.Lerp(-force.copys.rand.aspeed,force.copys.rand.aspeed,(float)Main.rand.nextDouble());
                            int num4 = (int) MathHelper.Lerp(-force.copys.rand.aspeedd,force.copys.rand.aspeedd,(float)Main.rand.nextDouble());
                            force.copys.aspeed+=num3;
                            force.copys.aspeedd+=(float)num4;
                            force.copys.speed+=num1;
                            force.copys.speedd+=(float)num2;
                            force.copys.aspeedx=force.copys.aspeed*(float)Math.cos(MathHelper.ToRadians(force.copys.aspeedd));
                            force.copys.aspeedy=force.copys.aspeed*(float)Math.sin(MathHelper.ToRadians(force.copys.aspeedd));
                            force.copys.speedx=force.copys.speed*(float)Math.cos(MathHelper.ToRadians(force.copys.speedd));
                            force.copys.speedy=force.copys.speed*(float)Math.sin(MathHelper.ToRadians(force.copys.speedd));
                        }
                    }
                    for(GlobalEvent globalEvent : Time.GE) {
                        globalEvent.qtcount=0;
                        globalEvent.stcount=0;
                    }
                    Time.stop=1f;
                }
                if(Time.now>=Time.left+105)
                    ++Time.left;
                for(int index = 0;index<Time.GE.size();++index) {
                    if(index+1==Time.now&&Time.GE.get(index).isgoto) {
                        ++Time.GE.get(index).gtcount;
                        if(Time.GE.get(index).gotowhere!=0&&(Time.GE.get(index).gototime==0||Time.GE.get(index).gtcount<=Time.GE.get(index).gototime))
                            Time.now=Time.GE.get(index).gotowhere;
                    }
                    if(GE.get(index).isquake&&now>=index+1) {
                        ++GE.get(index).qtcount;
                    }
                    if(Time.GE.get(index).isstop&&Time.now>=index+1) {
                        ++Time.GE.get(index).stcount;
                        if(Time.GE.get(index).stoptime==0||Time.GE.get(index).stcount<=Time.GE.get(index).stoptime) {
                            if(Time.GE.get(index).stoplevel==0)
                                Time.stop=(float)Time.GE.get(index).stcount/(float)Time.GE.get(index).stoptime*(float)Time.GE.get(index).stcount/(float)Time.GE.get(index).stoptime;
                            else if(Time.GE.get(index).stoplevel==1)
                                Time.stop=0.0f;
                        } else
                            Time.stop=1f;
                    }
                }
            }
            int num10 = Time.left+106;
            if(num10>=Time.total)
                num10-=num10-Time.total;
            if(Time.clCount==1) {
                ++Time.clwait;
                if(Time.clwait>15) {
                    Time.clwait=0;
                    Time.clCount=0;
                }
            }
            if(Main.Available&Time.search&!Time.Playing) {
                ++Time.time;
                if(Time.time>=30)
                    Time.time=0;
            }
        }
    }
