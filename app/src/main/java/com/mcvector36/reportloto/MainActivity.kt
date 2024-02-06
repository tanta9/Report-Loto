package com.mcvector36.reportloto

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mcvector36.reportloto.ui.theme.ReportLotoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReportLotoTheme {
                WebViewContent()
            }
        }
    }
}

@Composable
fun WebViewContent() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

                // Setarea cache-ului
                settings.domStorageEnabled
                settings.allowContentAccess
                settings.allowUniversalAccessFromFileURLs
                settings.allowFileAccess
                settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK) // Va încărca paginile din cache, dar va folosi rețeaua dacă nu sunt disponibile în cache



                loadUrl("https://www.loto.ro/?p=3872") // Înlocuiește cu URL-ul paginii web dorite
            }
        },
        update = { view ->
            view.loadUrl("https://www.loto.ro/?p=3872") // Înlocuiește cu URL-ul paginii web dorite
        }
    )
}
