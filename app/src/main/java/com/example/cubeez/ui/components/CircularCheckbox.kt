package com.example.cubeez.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularCheckbox(
    checked: Boolean,
    onCheckedChange: (() -> Unit)?,
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    color: Color = MaterialTheme.colorScheme.primary,
    enabled: Boolean = true
) {
    val borderColor = if (checked) color else MaterialTheme.colorScheme.onSurfaceVariant
    val backgroundColor = if (checked) color else Color.Transparent

    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .then(
                if (onCheckedChange != null && enabled) {
                    Modifier.clickable(
                        onClick = onCheckedChange,
                        role = Role.Checkbox
                    )
                } else Modifier
            )
            .border(
                width = 2.dp,
                color = borderColor,
                shape = CircleShape
            )
            .background(
                backgroundColor
            ),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(size * 0.6f)
            )
        }
    }
}


@Preview
@Composable
fun CircularCheckboxPreview() {
    CircularCheckbox(true, null)
}
