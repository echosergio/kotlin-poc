package upm.dam.kotlindemo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class PieChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)

        val chart = findViewById(R.id.pieChart) as PieChart

        val entries = ArrayList<PieEntry>()

        entries.add(PieEntry(18.5f, "Green"))
        entries.add(PieEntry(26.7f, "Yellow"))
        entries.add(PieEntry(24.0f, "Red"))
        entries.add(PieEntry(30.8f, "Blue"))

        val set = PieDataSet(entries, "Election Results")
        set.setColors(listOf(Color.GREEN, Color.YELLOW, Color.RED, Color.BLUE))

        val data = PieData(set)
        chart.setData(data)
        chart.invalidate() // refresh
    }
}
