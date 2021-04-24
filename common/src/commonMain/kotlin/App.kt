import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DownloadForOffline
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    MaterialTheme {
        Column {
            TextInput()
            NavigationBar()
        }
    }
}

expect fun getPlatformName(): String

@Composable
private fun NavigationBar() {
    Spacer(modifier = Modifier.height(16.dp))
    val navItemState = remember { mutableStateOf(NavType.LOG) }

    BottomNavigation {
        BottomNavigationItem(
            icon = { Icon(Icons.Outlined.Message, contentDescription = "Log") },
            selected = navItemState.value == NavType.LOG,
            onClick = { navItemState.value = NavType.LOG },
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Outlined.History, contentDescription = "History") },
            selected = navItemState.value == NavType.HISTORY,
            onClick = { navItemState.value = NavType.HISTORY },
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Outlined.Queue, contentDescription = "Queue") },
            selected = navItemState.value == NavType.QUEUE,
            onClick = { navItemState.value = NavType.QUEUE },
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Outlined.Settings, contentDescription = "Settings") },
            selected = navItemState.value == NavType.SETTINGS,
            onClick = { navItemState.value = NavType.SETTINGS },
        )
    }
}

private enum class NavType {
    LOG, HISTORY, QUEUE, SETTINGS
}

@Composable
private fun TextInput() {
    var ripUrl by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = ripUrl,
        trailingIcon = { Icon(Icons.Default.DownloadForOffline, contentDescription = "Download") },
        modifier = Modifier.padding(8.dp).fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "URL:") },
        placeholder = { Text(text = "Download URL.") },
        onValueChange = {
            ripUrl = it
        }
    )
}

