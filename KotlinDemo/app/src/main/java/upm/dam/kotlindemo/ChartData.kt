package upm.dam.kotlindemo

import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import kotlin.coroutines.experimental.buildSequence

class ChartData {

    private val companies = mutableListOf<Company>()

    fun addCompany(company: Company)
    {
        companies.add(company)
    }

    fun getChartData() = buildSequence {
        companies.forEach {
            val entries = ArrayList<Entry>()

            it.quarterEarnings
                    .sortedBy { it.quarter }
                    .forEach { entries.add(Entry(it.quarter.toFloat(), it.earnings.toFloat())) }

            val dataSet = LineDataSet(entries, it.name)
            dataSet.axisDependency = YAxis.AxisDependency.LEFT
            dataSet.setColor(it.color)
            dataSet.setCircleColor(it.color)

            yield(dataSet)
        }
    }
}
