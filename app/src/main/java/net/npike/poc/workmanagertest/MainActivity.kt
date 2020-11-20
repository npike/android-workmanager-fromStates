package net.npike.poc.workmanagertest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.npike.poc.workmanagertest.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.workInfoByTag.observe(this) {
            Timber.d("workInfoByTag: $it")

            binding.manualWorkInfo.text =
                "workInfoByTag\n${it.joinToString(separator = "\n")}"
        }

        viewModel.workInfoByState.observe(this) {
            Timber.d("workInfoByState: $it")

            binding.liveWorkInfo.text = "workInfoByState\n" + it.joinToString(separator = "\n")
        }
    }
}