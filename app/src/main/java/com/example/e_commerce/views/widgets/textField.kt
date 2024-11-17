package com.example.e_commerce.views.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.e_commerce.ui.theme.blue

@Composable
fun MyTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    label: String,
    error: String,
    onErrorChange: (String) -> Unit,
    isPasswordField: Boolean = false,
    passwordVisible: Boolean = false,
    onPasswordVisibilityChange: (Boolean) -> Unit = {},
) {
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp)) // Add clipping to match rounded shape
                    .border(
                        BorderStroke(1.dp, if (error.isNotEmpty()) Color.Red else blue), // Apply border color dynamically
                        shape = RoundedCornerShape(15.dp),
                    ),
            // Apply a blue border using the border modifier
            shape = RoundedCornerShape(15.dp), // Apply rounded shape to TextField
            colors =
                TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White, // Set the background to white
                    focusedContainerColor = Color.White,
                    unfocusedIndicatorColor = Color.Transparent, // Remove the default indicator color
                    focusedIndicatorColor = Color.Transparent, // Remove the default indicator color
                    cursorColor = Color.Black, // Set the cursor color to black
                ),
            placeholder = { Text(text = "Enter your $label", color = Color.Gray) },
            visualTransformation = if (isPasswordField && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            suffix =
                if (isPasswordField) {
                    {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            modifier = Modifier.clickable { onPasswordVisibilityChange(!passwordVisible) },
                        )
                    }
                } else {
                    null
                },
        )
        if (error.isNotEmpty()) {
            Text(text = error, color = Color.Red, fontSize = 12.sp)
        }
    }
}

@Preview
@Composable
private fun TextFieldPrev() {
    MyTextField(
        value = TextFieldValue(""), // Initial text value (empty in this case)
        onValueChange = {}, // No-op for preview
        label = "Password", // Label text for the field
        error = "", // No error for preview
        onErrorChange = {}, // No-op for preview
        isPasswordField = true, // To show password field behavior
        passwordVisible = false, // Password visibility initially off
        onPasswordVisibilityChange = {}, // No-op for preview
    )
}
