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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*
import de.hackr.dev.watchschemer.theme.WatchSchemerTheme
import kotlin.random.Random

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

            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                autoCentering = AutoCenteringParams(itemIndex = 0),
                state = listState
            ) {
                item { Schemer() }
                item { Spacer(modifier = Modifier.height(8.dp)) }
                item { Schemer() }
                item { Spacer(modifier = Modifier.height(8.dp)) }
                item { Schemer() }
                item { Spacer(modifier = Modifier.height(8.dp)) }
                item { Schemer() }
                item { Spacer(modifier = Modifier.height(8.dp)) }
            }
        }
    }
}

@Composable
fun Schemer() {
    val r1 = Random.nextInt(10, 245)
    val g1 = Random.nextInt(10, 245)
    val b1 = Random.nextInt(10, 245)
    val stop1 = Random.nextInt(10, 150)
    val r2 = Random.nextInt(10, 245)
    val g2 = Random.nextInt(10, 245)
    val b2 = Random.nextInt(10, 245)
    val stop2 = Random.nextInt(stop1, 180)
    val r3 = Random.nextInt(10, 245)
    val g3 = Random.nextInt(10, 245)
    val b3 = Random.nextInt(10, 245)
    val stop3 = 220
    Column(Modifier.height(220.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(r1, g1, b1))
                .height(stop1.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(r2, g2, b2))
                .height((stop2 - stop1).dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(r3, g3, b3))
                .height((stop3 - stop2).dp)
        )
    }
}