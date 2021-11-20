package id.ac.ukdw.pertemuan8_71190455

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //viewpager
        val pager = findViewById<ViewPager2>(R.id.pager)
        val listFragment = listOf<Fragment>(FragmenFirst(),SecondFragment(),ThirdFragment())
        val pagerAdapter = PagerAdapter(this,listFragment)
        pager.adapter = pagerAdapter


    }

    class PagerAdapter(val activity: AppCompatActivity, val listFragment: List<Fragment>): FragmentStateAdapter(activity){
        override fun getItemCount(): Int  = listFragment.size

        override fun createFragment(position: Int): Fragment = listFragment.get(position)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val pager = findViewById<ViewPager2>(R.id.pager)
        val listFragment = listOf<Fragment>(FragmenFirst(),SecondFragment(),ThirdFragment())
        val pagerAdapter = PagerAdapter(this,listFragment)
        pager.adapter = pagerAdapter
        when(item.itemId){
//            R.id.menu_profile -> Toast.makeText(this, "page 1",Toast.LENGTH_SHORT).show()
//            R.id.menu_profile1 -> Toast.makeText(this, "page 2",Toast.LENGTH_SHORT).show()
//            R.id.menu_profile2 -> Toast.makeText(this, "page 3",Toast.LENGTH_SHORT).show()
            R.id.menu_profile -> {
                pager.setCurrentItem(0)
            }
            R.id.menu_profile1 -> {
                pager.setCurrentItem(1)
            }
            R.id.menu_profile2 -> {
                pager.setCurrentItem(2)
            }
        }


        return super.onOptionsItemSelected(item)
    }
}