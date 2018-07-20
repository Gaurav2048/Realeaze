package com.realeaze.realeaze.fragments.Progress;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.realeaze.realeaze.R;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphprojectFragment extends Fragment {

   LineChart lineChart;
    List<Entry> entries = new ArrayList<Entry>();

   TabLayout tabs;View view;
   FrameLayout layout;
    LineDataSet dataSet;Entry lastEntry;
     View main;
    String[] monthNames;
    public GraphprojectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          view= inflater.inflate(R.layout.fragment_graphproject, container, false);
        layout = view.findViewById(R.id.layout__);
         lineChart =view.findViewById(R.id.chart);
        lineChart.setTouchEnabled(true);
        lastEntry = null;
        LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       main =  inflater1.inflate(R.layout.graph_data, null);
 //       lineChart.setScaleMinima(6,6);
       tabs =(TabLayout) view.findViewById(R.id.tabs);

entries.add(new Entry(1,20));
        entries.add(new Entry(2,15));
        entries.add(new Entry(3,16));
        entries.add(new Entry(4,16));
        entries.add(new Entry(5,18));
        entries.add(new Entry(6,17));
        entries.add(new Entry(7,16));
        entries.add(new Entry(8,13));
        entries.add(new Entry(9,15));
        entries.add(new Entry(10,18));
        entries.add(new Entry(11,16));
        entries.add(new Entry(12,22));
        entries.add(new Entry(13,20));
        entries.add(new Entry(14,16));
        entries.add(new Entry(15,18));
        entries.add(new Entry(16,17));
        entries.add(new Entry(17,16));
        entries.add(new Entry(18,13));
        entries.add(new Entry(19,15));
        entries.add(new Entry(20,18));
        entries.add(new Entry(21,15));
        entries.add(new Entry(22,15));
        entries.add(new Entry(23,15));
        entries.add(new Entry(24,19));
        entries.add(new Entry(25,18));
        entries.add(new Entry(26,15));
        entries.add(new Entry(27,14));
        entries.add(new Entry(28,10));
        entries.add(new Entry(29,10));
        entries.add(new Entry(30,19));

        DateFormatSymbols symbols = new DateFormatSymbols();
         monthNames = symbols.getMonths();

           dataSet = new LineDataSet(entries, "");
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setLineWidth(2.0f);
       //  lineChart.getAxisLeft().setEnabled(false);
        //lineChart.getAxisRight().setEnabled(false);
        lineChart.setDrawBorders(false);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.getViewPortHandler().setMinimumScaleX(5f);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        lineChart.getAxisRight().setGridColor(Color.argb(255, 203,203, 203));
        lineChart.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        lineChart.getRenderer().getPaintRender().setShadowLayer(3, 5, 3, Color.argb(165,246, 231, 228));
         dataSet.setColor(Color.argb(255, 247,93,67));

       // dataSet.setCircleColorHole(Color.WHITE);
       //dataSet.setCircleColor(Color.argb(255, 247,93,67));
        dataSet.setValueTextColor(Color.argb(255, 247,93,67)); // styling, ...
        dataSet.setDrawCircleHole(false);
        dataSet.setDrawCircles(false);
        final LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate(); // r
        lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @SuppressLint("NewApi")
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                MPPointD point = lineChart.getTransformer(YAxis.AxisDependency.LEFT).getPixelForValues(e.getX(),e.getY());
                double xValue = point.x;
                double yValue = point.y;
            //    dataSet.setCircleColorHole(Color.WHITE);
            //    dataSet.setCircleColor(Color.argb(255, 247,93,67));
              if(lastEntry== null){
                  lastEntry = e;
              }else {

                  dataSet.getEntryForIndex((int)lastEntry.getX()-1).setIcon(null);
                  lastEntry = e;
              }
                dataSet.getEntryForIndex((int)e.getX()-1).setIcon(getContext().getDrawable(R.drawable.concentric));
                //dataSet.getEntryForIndex((int)e.getX()-1).setIcon(null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                  createLayout(xValue,yValue, e);
                }
                Toast.makeText(getContext(), "vl"+""+xValue+" "+yValue , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
        createTabIcons();
        tabs.getTabAt(0).select();
      highlIghtTab(tabs.getTabAt(0), 0);
      tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
          @Override
          public void onTabSelected(TabLayout.Tab tab) {
              highlIghtTab(tab, tabs.getSelectedTabPosition());
          }

          @Override
          public void onTabUnselected(TabLayout.Tab tab) {
         shlwTab(tab);
          }

          @Override
          public void onTabReselected(TabLayout.Tab tab) {

          }
      });
        return  view;
    }

     private void createLayout(double xValue, double yValue, Entry e) {
       if(main.getParent()==layout){
           layout.removeView(main);
       }
        LinearLayout.LayoutParams rel_params= new LinearLayout.LayoutParams(150 ,120 );
         rel_params.leftMargin=(int)xValue+8;
        rel_params.topMargin= (int)yValue-4;
        main.setLayoutParams(rel_params);

        layout.addView(main);

    }

    private void shlwTab(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        TextView name = view.findViewById(R.id.text);
        view.setBackground(null);
        name.setTextColor(Color.argb(255, 187, 192, 198));
        ImageView front = view.findViewById(R.id.front);
        ImageView back = view.findViewById(R.id.back);
        front.setEnabled(false);
        back.setEnabled(false);
        front.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
    }
   /* protected void drawHorizontalBezier(ILineDataSet dataSet) {

        float phaseY = mAnimator.getPhaseY();

        Transformer trans = lineChart.getTransformer(dataSet.getAxisDependency());

        mXBounds.set(lineChart, dataSet);

        cubicPath.reset();

        if (mXBounds.range >= 1) {

            Entry prev = dataSet.getEntryForIndex(mXBounds.min);
            Entry cur = prev;

            // let the spline start
            cubicPath.moveTo(cur.getX(), cur.getY() * phaseY);

            for (int j = mXBounds.min + 1; j <= mXBounds.range + mXBounds.min; j++) {

                prev = cur;
                cur = dataSet.getEntryForIndex(j);

                final float cpx = (prev.getX())
                        + (cur.getX() - prev.getX()) / 2.0f;

                cubicPath.cubicTo(
                        cpx, prev.getY() * phaseY,
                        cpx, cur.getY() * phaseY,
                        cur.getX(), cur.getY() * phaseY);
            }
        }

        // if filled is enabled, close the path
        if (dataSet.isDrawFilledEnabled()) {

            cubicFillPath.reset();
            cubicFillPath.addPath(cubicPath);
            // create a new path, this is bad for performance
            drawCubicFill(mBitmapCanvas, dataSet, cubicFillPath, trans, mXBounds);
        }

        mRenderPaint.setColor(dataSet.getColor());

        mRenderPaint.setStyle(Paint.Style.STROKE);

        trans.pathValueToPixel(cubicPath);

        mBitmapCanvas.drawPath(cubicPath, mRenderPaint);

        mRenderPaint.setPathEffect(null);
    }*/
    private void highlIghtTab(final TabLayout.Tab tab, final int i) {
        View view = tab.getCustomView();
        TextView name = view.findViewById(R.id.text);
        view.setBackgroundResource(R.drawable.tab_back);
        name.setTextColor(Color.argb(255, 247, 93, 67));
        ImageView front = view.findViewById(R.id.front);
        ImageView back = view.findViewById(R.id.back);
        front.setEnabled(true);
        back.setEnabled(true);
        front.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // toast
                if(i!=11) {
                    tabs.getTabAt(i + 1).select();
                    shlwTab(tab);
                    highlIghtTab(tabs.getTabAt(i + 1), i + 1);
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i!=0){
                    tabs.getTabAt(i-1).select();
                    shlwTab(tab);
                    highlIghtTab(tabs.getTabAt(i-1), i-1);
                }
            }
        });
        // click listner
    }

    private void createTabIcons() {
        for(int i=0;i<12;i++){
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/OpenSans-Regular.ttf");
        LinearLayout tabOne = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.amaze_tab, null);
        tabOne.setBackground(null);
            Log.e( "createTabIcons: ",i+" " );
        TextView tv_= (TextView) tabOne.findViewById(R.id.text);
        tv_.setTypeface(typeface);
             tv_.setText("Design");

            // tv_.setText(monthNames[i]);
        ImageView im_back = (ImageView) tabOne.findViewById(R.id.back);
        im_back.setVisibility(View.INVISIBLE);
        ImageView im_front = (ImageView) tabOne.findViewById(R.id.front);
        im_front.setVisibility(View.INVISIBLE);
        im_back.setEnabled(false);
        im_front.setEnabled(false);
        tabs.addTab(tabs.newTab().setCustomView(tabOne));

        }

    }

}
