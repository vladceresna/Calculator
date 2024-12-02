package com.vladceresna.calculator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme(colorScheme = lightColorScheme(Color(0xFF006E19))) {
        Surface {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Calculator") }
                    )
                }
            ) {
                    var action by remember { mutableStateOf("") }
                    var result by remember { mutableStateOf("") }

                    Column(Modifier.padding(10.dp,64.dp,10.dp,10.dp).fillMaxSize()) {
                        Row(Modifier.fillMaxWidth()) {
                            Column(Modifier.weight(1f).align(Alignment.Bottom)) {
                                Text(modifier = Modifier.weight(1f),text = result,fontSize = TextUnit(20f, TextUnitType.Sp))
                                Row(Modifier.padding(2.dp)) {
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "1" }
                                    ) { Text("1", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "2" }
                                    ) { Text("2", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "3" }
                                    ) { Text("3", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                }
                                Row(Modifier.padding(2.dp)) {
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "4" }
                                    ) { Text("4", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "5" }
                                    ) { Text("5", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "6" }
                                    ) { Text("6", fontSize = TextUnit(20f, TextUnitType.Sp)) }

                                }
                                Row(Modifier.padding(2.dp)) {
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "7" }
                                    ) { Text("7", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "8" }
                                    ) { Text("8", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "9" }
                                    ) { Text("9", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                }
                                Row(Modifier.padding(2.dp)) {
                                    Button(modifier = Modifier.weight(1f),onClick = { result += "0" }
                                    ) { Text("0", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                }
                            }
                            Column(Modifier) {
                                Button(modifier = Modifier.padding(2.dp),onClick = {
                                    result = result.substring(0, result.length - 1)
                                }
                                ) { Text("<-", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                Button(modifier = Modifier.padding(2.dp),onClick = { action = "+"
                                    result += action}
                                ) { Text("+", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                Button(modifier = Modifier.padding(2.dp),onClick = { action = "-"
                                    result += action}
                                ) { Text("-", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                Button(modifier = Modifier.padding(2.dp),onClick = { action = "*"
                                    result += action}
                                ) { Text("*", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                Button(modifier = Modifier.padding(2.dp),onClick = { action = "/"
                                    result += action}
                                ) { Text("/", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                                Button(modifier = Modifier.padding(2.dp),onClick = {
                                    var nums=result.split(action)
                                    result = when(action) {
                                        "+" -> nums[0].toInt() + nums[1].toInt()
                                        "-" -> nums[0].toInt() - nums[1].toInt()
                                        "*" -> nums[0].toInt() * nums[1].toInt()
                                        "/" -> nums[0].toInt() / nums[1].toInt()
                                        else -> ""
                                    }.toString()
                                }
                                ) { Text("=", fontSize = TextUnit(20f, TextUnitType.Sp)) }
                            }
                        }
                    }

            }
        }
    }
}