package upm.dam.kotlindemo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineData

class LineChartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)

        val chart = findViewById(R.id.lineChart) as LineChart

        var company1 = Company("Company 1")
        company1.quarterEarnings.addAll(
                listOf(
                        QuarterlyEarnings(1, 140000),
                        QuarterlyEarnings(2, 150000),
                        QuarterlyEarnings(3, 170000),
                        QuarterlyEarnings(4, 180000)))

        var company2 = Company("Company 2", Color.BLUE)
        company2.quarterEarnings.addAll(
                listOf(
                        QuarterlyEarnings(1, 160000),
                        QuarterlyEarnings(2, 180000),
                        QuarterlyEarnings(3, 190000),
                        QuarterlyEarnings(4, 220000)))

        val companies = listOf(company1, company2)

        val dataSets = companies.toDataSet()
        val data = LineData(dataSets)

        chart.setData(data)
        chart.invalidate()
    }
}
