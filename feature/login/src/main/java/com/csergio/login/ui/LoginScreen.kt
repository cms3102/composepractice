package com.csergio.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.csergio.features.login.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(onLogin: () -> Unit) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var error by remember { mutableStateOf(false) }
    var passwordVisualTransformation by remember { mutableStateOf<VisualTransformation>(PasswordVisualTransformation()) }
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        modifier = Modifier.padding(
            start = 20.dp,
            top = 0.dp,
            end = 20.dp,
            bottom = 0.dp
        )
    ) { paddings ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.login))
            LottieAnimation(
                composition = composition,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = stringResource(id = R.string.login_title),
                style = MaterialTheme.typography
                    .titleLarge
                    .copy(fontSize = 40.sp)
            )

            Text(
                text = "Please sign in",
                style = MaterialTheme.typography.bodyMedium
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                maxLines = 1,
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "")
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Email Address")
                },
                placeholder = { Text(text = "abc@gmail.com") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                isError = error
            )

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                },
                maxLines = 1,
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = "")
                },
                trailingIcon = {
                  Icon(
                      imageVector = Icons.Default.Info,
                      contentDescription = "",
                      modifier = Modifier.clickable {
                          passwordVisualTransformation = if (passwordVisualTransformation != VisualTransformation.None) {
                              VisualTransformation.None
                          } else {
                              PasswordVisualTransformation()
                          }
                      }
                  )
                },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = "Password")
                },
                placeholder = { Text(text = "123456") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = passwordVisualTransformation,
                isError = error
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
                    .clip(CircleShape)
                    .height(50.dp),
                onClick = { 
                    if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                        error = false
                        onLogin.invoke()
                        keyboardController?.hide()
                    } else {
                        error = true
                    }
                }
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp)
                )
            }

            Box(modifier = Modifier.padding(vertical = 15.dp)) {
                Divider(
                    modifier = Modifier.align(Alignment.Center),
                    thickness = 1.dp,
                    color = Color.LightGray,
                )
                Text(
                    text = "Or use",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .background(Color.White)
                        .padding(horizontal = 5.dp)
                )
            }

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "",
                    tint = LocalContentColor.current
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Login with Google",
                    style = MaterialTheme.typography.titleSmall.copy(fontSize = 18.sp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "",
                    tint = LocalContentColor.current
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Login with Kakao",
                    style = MaterialTheme.typography.titleSmall.copy(fontSize = 18.sp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            val registerString = "If you don't have an account, Sign Up"
            val highlightString = "Sign Up"
            val start = registerString.indexOf(highlightString)
            val end = start + highlightString.length
            val annotatedString = AnnotatedString.Builder(registerString).apply {
                addStyle(style = SpanStyle(color = Color.Blue), start = start, end = end)
            }.toAnnotatedString()
            Text(
                text = annotatedString,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .clickable {  }
            )
        }
    }
}