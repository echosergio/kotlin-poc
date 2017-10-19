package upm.dam.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View;



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showPieChart(view: View) {
        val intent = Intent(this@MainActivity, PieChartActivity::class.java)
        startActivity(intent)
    }

    fun showLineChart(view: View) {
        val intent = Intent(this@MainActivity, LineChartActivity::class.java)
        startActivity(intent)
    }


}
