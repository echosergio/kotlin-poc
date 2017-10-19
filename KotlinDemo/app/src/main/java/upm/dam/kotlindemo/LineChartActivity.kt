package upm.dam.kotlindemo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.components.YAxis.AxisDependency
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet


class LineChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)

        // in this example, a LineChart is initialized from xml
        val chart = findViewById(R.id.lineChart) as LineChart

        val valsComp1 = ArrayList<Entry>()
        val valsComp2 = ArrayList<Entry>()

        valsComp1.add(Entry(0f, 100000f))
        valsComp1.add(Entry(1f, 140000f))
        valsComp1.add(Entry(2f, 150000f))
        valsComp1.add(Entry(3f, 170000f))
        valsComp1.add(Entry(4f, 190000f))
        valsComp1.add(Entry(5f, 230000f))

        valsComp2.add(Entry(0f, 130000f))
        valsComp2.add(Entry(1f, 115000f))
        valsComp2.add(Entry(2f, 140000f))
        valsComp2.add(Entry(3f, 130000f))
        valsComp2.add(Entry(4f, 180000f))
        valsComp2.add(Entry(5f, 200000f))

        val setComp1 = LineDataSet(valsComp1, "Company 1")
        setComp1.axisDependency = AxisDependency.LEFT
        setComp1.setColor(Color.RED)
        setComp1.setCircleColor(Color.RED)

        val setComp2 = LineDataSet(valsComp2, "Company 2")
        setComp2.axisDependency = AxisDependency.LEFT
        setComp2.setColor(Color.BLUE)
        setComp2.setCircleColor(Color.BLUE)

        chart.getXAxis().setEnabled(false);

        // use the interface ILineDataSet
        val dataSets = ArrayList<ILineDataSet>()
        dataSets.add(setComp1)
        dataSets.add(setComp2)

        val data = LineData(dataSets)
        chart.setData(data)
        chart.invalidate() // refresh
    }
}
