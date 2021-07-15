package com.example.internshipproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.internshipproject.databinding.ActivityMainBinding
import com.example.internshipproject.network.response.get.WordData
import com.example.internshipproject.ui.adapters.SynonymsRecyclerAdapter
import com.example.internshipproject.ui.adapters.VideoRecyclerAdapter
import com.example.internshipproject.utils.Status
import com.example.internshipproject.viewModel.YourDictionaryViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: YourDictionaryViewModel by lazy {
        ViewModelProvider(this).get(YourDictionaryViewModel::class.java)
    }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getWordData()
        viewModel.wordResponse.observe(this, Observer { result ->
            when (result.status) {
                Status.SUCCESS -> {
                    /**Success in getting the result now update the UI **/
                    result.data?.let {
                        setUpUi(it)
                    }
                }
                Status.ERROR -> {
                    /**There is an error in the result,now show the toast message to the user**/

                    Toast.makeText(this, "Error! Please try later", Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

    private fun setUpUi(wordData: WordData) {
        /** make views visible and make progress bar invisible**/
        binding.progressBar.visibility= View.GONE
        binding.videoHeader.visibility=View.VISIBLE
        binding.card1.visibility=View.VISIBLE
        binding.card2.visibility=View.VISIBLE
        binding.newWordTitle.visibility=View.VISIBLE
        binding.card3.visibility=View.VISIBLE

        /** load headers **/
        binding.word.text = wordData.wordDay.word
        binding.videoHeader.text = wordData.videos.header
        binding.newWordTitle.text = wordData.wordDay.header
        binding.meaningStatement.text = wordData.wordDay.generic

        /** set up adapter for videoRecyclerView **/
        binding.videoRev.adapter = VideoRecyclerAdapter(wordData.videos.vids)
        binding.videoRev.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /** set up adapter for synonymsRecyclerView **/
        binding.synonymsRev.adapter = SynonymsRecyclerAdapter(wordData.wordDay.synonym)
        binding.synonymsRev.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


    }
}