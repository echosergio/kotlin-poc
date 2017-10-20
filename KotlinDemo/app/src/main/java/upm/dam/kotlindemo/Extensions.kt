package upm.dam.kotlindemo

import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

fun List<Company>.toDataSet(): ArrayList<ILineDataSet> {
    val dataSets = ArrayList<ILineDataSet>()

    this.forEach {
        val entries = ArrayList<Entry>()

        it.quarterEarnings
                .sortedBy { it.quarter }
                .forEach { entries.add(Entry(it.quarter.toFloat(), it.earnings.toFloat())) }

        val dataSet = LineDataSet(entries, it.name)
        dataSet.axisDependency = YAxis.AxisDependency.LEFT
        dataSet.setColor(it.color)
        dataSet.setCircleColor(it.color)

        dataSets.add(dataSet)
    }

    return dataSets
}
