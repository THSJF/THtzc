package runner;

import java.util.*;
import runner.*;
import runner.layer.*;

public class Layer {
        public static ArrayList<Layer> LayerArray = new ArrayList<Layer>();
        public static int total = 0;
        public static int selection = 0;
        public static int oldcolor = 0;
        public String name;
        public int sort;
        public boolean Visible;
        public int color;
        public int begin;
        public int end;
        public boolean NeedDelete;
        public ArrayList<Batch> BatchArray;
        public ArrayList<Lase> LaseArray;
        public ArrayList<Cover> CoverArray;
        public ArrayList<Rebound> ReboundArray;
        public ArrayList<Force> ForceArray;
        public ArrayList<Barrage> Barrages;

        public static void Clear() {
            total=0;
            selection=0;
            oldcolor=0;
            LayerArray.clear();
        }

        public Layer(String nm,int bg,int ed) {
            name=nm;
            Visible=true;
            sort=LayerArray.size();
            selection=0;
            color=oldcolor;
            ++oldcolor;
            if(oldcolor>6) {
                oldcolor=0;
            }
            begin=bg;
            end=ed;
            ++total;
            NeedDelete=false;
            BatchArray=new ArrayList<Batch>();
            LaseArray=new ArrayList<Lase>();
            CoverArray=new ArrayList<Cover>();
            ReboundArray=new ArrayList<Rebound>();
            ForceArray=new ArrayList<Force>();
            Barrages=new ArrayList<Barrage>();
            LayerArray.put(this);
        }

        public void Update() {
            if(!Main.Available) {
                return;
            }    
            if(!Visible) {
                return;
            }
            for(int index = 0;index<ForceArray.size();++index) {
                ForceArray[index].id=index;
                ForceArray[index].parentid=sort;
                if(!Time.Playing) {
                    ForceArray[index].Update();
                } else {
                    ForceArray[index].copys.Update();
                }
            }
            for(int index = 0;index<ReboundArray.size();++index) {
                ReboundArray[index].id=index;
                ReboundArray[index].parentid=this.sort;
                if(!Time.Playing) {
                    ReboundArray[index].Update();
                } else {
                    ReboundArray[index].copys.Update();
                }
            }
            for(int index = 0;index<CoverArray.size();++index) {
                CoverArray[index].id=index;
                CoverArray[index].parentid=sort;
                if(!Time.Playing) {
                    CoverArray[index].Update();
                } else {
                    CoverArray[index].copys.Update();
                }
            }
            for(int index = 0;index<LaseArray.size();++index) {
                LaseArray[index].id=index;
                LaseArray[index].parentid=sort;
                if(!Time.Playing) {
                    LaseArray[index].Update();
                } else {
                    LaseArray[index].copys.Update();
                }
            }
            for(int index = 0;index<BatchArray.size();++index) {
                BatchArray[index].id=index;
                BatchArray[index].parentid=sort;
                if(!Time.Playing) {
                    BatchArray[index].Update();
                } else {
                    BatchArray[index].copys.Update();
                }
            }
            if(!Time.Playing) {
                return;
            }
            for(int index = 0;index<Barrages.size();++index) {
                Barrages[index].id=index;
                Barrages[index].Update();
                Barrages[index].LUpdate();
            }
        }
    }
