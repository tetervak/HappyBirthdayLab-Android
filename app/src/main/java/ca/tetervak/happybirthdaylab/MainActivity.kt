package ca.tetervak.happybirthdaylab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.happybirthdaylab.ui.theme.HappyBirthdayLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayLabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(
                        receiver = stringResource(R.string.receiver_name),
                        sender = stringResource(R.string.sender_name)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(receiver: String, sender: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.birthday_message, receiver),
            fontSize = 28.sp,
            color = colorResource(R.color.pink_500),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(top = 32.dp)
        )
        Text(
            text = stringResource(R.string.from_message, sender),
            fontSize = 20.sp,
            color = colorResource(R.color.deep_purple_500),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .padding(top = 16.dp, end = 32.dp)
        )
    }

}

@Composable
fun BirthdayGreetingWithImage(receiver: String, sender: String){
    val image = painterResource(R.drawable.androidparty)
    Box{
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(receiver, sender)
    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
    HappyBirthdayLabTheme {
        BirthdayGreetingWithImage(
            receiver = stringResource(R.string.receiver_name),
            sender = stringResource(R.string.sender_name)
        )
    }
}