package upm.dam.kotlindemo

import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

fun List<Company>.toDataSet(): List<ILineDataSet> {
    return this.map { company -> convertToDataSet(company) }
}

fun convertToDataSet(company: Company): ILineDataSet {
    val entries = ArrayList<Entry>()

    company.quarterEarnings
            .sortedBy { it.quarter }
            .forEach { entries.add(Entry(it.quarter.toFloat(), it.earnings.toFloat())) }

    val dataSet = LineDataSet(entries, company.name)

    dataSet.axisDependency = YAxis.AxisDependency.LEFT
    dataSet.setColor(company.color)
    dataSet.setCircleColor(company.color)

    return dataSet
}