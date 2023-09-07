import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ChatMessage(text: String, isUser: Boolean) {
    val messageAlignment = if (isUser) Alignment.End else Alignment.Start
    val messageBackgroundColor = if (isUser) Color(0xFFC8E6C9) else Color(0xFFB3E0FF)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Card(
            modifier = Modifier
                .background(messageBackgroundColor)
                .padding(8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = text, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ChatScreen() {
    val customTextStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    var userInput by remember { mutableStateOf(TextFieldValue()) }
    val chatMessages = remember { mutableListOf<Pair<String, Boolean>>() }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Chat de Dicas Alimentares",
                style = customTextStyle,
                modifier = Modifier
                    .padding(10.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                TopicLink("Dieta")
                TopicLink("Nutrição")
                TopicLink("Alimentos Saudáveis")
            }

            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(start = 16.dp)
            ) {
                // Área de chat
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    chatMessages.forEach { (message, isUserMessage) ->
                        ChatMessage(text = message, isUser = isUserMessage)
                    }
                }

                // Caixa de entrada de mensagem
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = userInput.text,
                        onValueChange = {
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )

                    Button(
                        onClick = {
                            if (userInput.text.isNotBlank()) {
                                chatMessages.add(userInput.text to true)
                                userInput = TextFieldValue("")
                            }
                        },
                        modifier = Modifier
                            .padding(end = 8.dp)
                    ) {
                        Text("Enviar")
                    }

                    Button(
                        onClick = { /* Lógica para pausar consulta */ },
                        modifier = Modifier
                    ) {
                        Text("Pausar Consulta")
                    }
                }
            }
        }
    }
}

@Composable
fun TopicLink(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .padding(bottom = 8.dp)
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ChatScreenPreview() {
    ChatScreen()
}

