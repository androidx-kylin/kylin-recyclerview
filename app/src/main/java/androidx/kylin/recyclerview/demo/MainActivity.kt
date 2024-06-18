package androidx.kylin.recyclerview.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.kylin.recyclerview.demo.databinding.ActivityMainBinding
import androidx.kylin.recyclerview.demo.databinding.SampleItemBinding
import androidx.kylin.recyclerview.demo.sample.BasicAdapterActivity
import androidx.kylin.recyclerview.setup
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val classMap = mutableMapOf(
        R.id.btn_basic_sample to BasicAdapterActivity::class.java,
        R.id.btn_basic_anim to BasicAdapterActivity::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ActivityMainBinding.inflate(layoutInflater).also { binding ->
            setContentView(binding.root)
            binding.javaClass.declaredFields
                .filter { it.type == Button::class.java }
                .forEach { field ->
                    (field.get(binding) as Button).setOnClickListener {
                        val clazz = classMap[it.id] ?: return@setOnClickListener
                        startActivity(Intent(it.context, clazz))
                    }
                }
        }

        val rv: RecyclerView = RecyclerView(this)
        rv.setup {
            layout { }
            datasource { arrayOf(1, 2, 3, 4) }
            binding(SampleItemBinding::class) {

            }
        }
    }
}