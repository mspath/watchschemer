/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.hackr.dev.watchschemer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import de.hackr.dev.watchschemer.theme.WatchSchemerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WatchSchemer()
        }
    }
}

@Composable
fun WatchSchemer() {
    WatchSchemerTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .selectableGroup(),
            verticalArrangement = Arrangement.Center
        ) {
            val listState = rememberScalingLazyListState()
            val size = 10

            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                autoCentering = AutoCenteringParams(itemIndex = 0),
                state = listState
            ) {

                repeat(size) {
                    item { Coloroidable() }
                    item { Spacer(modifier = Modifier.height(8.dp)) }
                }
            }
        }
    }
}

@Composable
fun Coloroidable() {

    val coloroid = Generator.randomColoroid()

    Column(Modifier.height(220.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(coloroid.color1)
                .fillMaxHeight(coloroid.stop1)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(coloroid.color2)
                .fillMaxHeight(coloroid.stop2 - coloroid.stop1)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(coloroid.color3)
                .fillMaxHeight(1 - coloroid.stop2)
        )
    }
}