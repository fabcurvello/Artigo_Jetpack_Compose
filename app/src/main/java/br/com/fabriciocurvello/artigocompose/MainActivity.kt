package br.com.fabriciocurvello.artigocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fabriciocurvello.artigocompose.ui.theme.ArtigoComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtigoComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ItensTela(
                        titulo = stringResource(R.string.titulo),
                        paragrafo1 = stringResource(R.string.paragrafo1),
                        paragrafo2 = stringResource(R.string.paragrafo2),
                    )
                }
            }
        }
    }
}

@Composable
fun BannerImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = null, contentScale = ContentScale.FillWidth, alpha = 1.0F)
}

@Composable
fun ItensTela(titulo: String, paragrafo1: String, paragrafo2: String, modifier: Modifier = Modifier) {
    Column ( verticalArrangement = Arrangement.Center, modifier = modifier){
        BannerImage()
        Text(text = titulo, fontSize = 24.sp, modifier = Modifier.padding(all = 16.dp))
        Text(text = paragrafo1, modifier = Modifier.padding(start = 16.dp, end = 16.dp), textAlign = TextAlign.Justify)
        Text(text = paragrafo2, modifier = Modifier.padding(all = 16.dp), textAlign = TextAlign.Justify)
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Meu Preview")
@Composable
fun GreetingPreview() {
    ArtigoComposeTheme {
        ItensTela(titulo = stringResource(R.string.ex_titulo), paragrafo1 = stringResource(R.string.ex_par1), paragrafo2 = stringResource(
            R.string.ex_par2
        )
        )
    }
}