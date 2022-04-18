package by.iapsit.notikeep.presentation.mvi.ui.applications

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.iapsit.notikeep.R
import by.iapsit.notikeep.domain.entities.PackageData
import by.iapsit.notikeep.presentation.mvi.ui.common.Loading
import by.iapsit.notikeep.presentation.utils.isIndexLast
import coil.compose.AsyncImage
import org.koin.androidx.compose.getViewModel

@Composable
fun ApplicationsScreen(viewModel: ApplicationsViewModel = getViewModel()) {
    val state = viewModel.state.collectAsState().value
    Surface(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is ApplicationsContract.State.Loading -> Loading()
            is ApplicationsContract.State.ShowApplicationList -> {
                ApplicationList(packages = state.packages)
            }
        }
    }
}

@Composable
fun ApplicationList(packages: List<PackageData>) {
    LazyColumn {
        itemsIndexed(packages) { index, packageData ->
            ApplicationItem(packageData) {
                //TODO: Add favourites
            }
            if (!packages.isIndexLast(index)) Divider()
        }
    }
}

@Composable
fun ApplicationItem(data: PackageData, favouriteButtonClickAction: () -> Unit) {
    val packageName = data.packageName
    val packageManager = LocalContext.current.packageManager
    val packageInfo = packageManager.getApplicationInfo(packageName, 0)
    val name = packageManager.getApplicationLabel(packageInfo).toString()
    val icon = packageManager.getApplicationIcon(packageInfo)
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = icon,
            contentDescription = null,
            modifier = Modifier.size(52.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 12.dp, end = 12.dp)
                .fillMaxWidth(0.9F),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = name,
                style = TextStyle(fontSize = 20.sp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = packageName,
                    style = TextStyle(fontSize = 16.sp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
        Icon(
            painter = if (data.isFavourite) {
                painterResource(R.drawable.ic_filled_heart)
            } else painterResource(R.drawable.ic_unfilled_heart),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .clickable(interactionSource = interactionSource, indication = null) {
                    favouriteButtonClickAction()
                },
            tint = if (data.isFavourite) {
                MaterialTheme.colors.primary
            } else MaterialTheme.colors.onBackground
        )
    }
}