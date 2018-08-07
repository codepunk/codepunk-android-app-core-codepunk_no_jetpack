/*
 * Copyright (C) 2018 Codepunk, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codepunk.codepunk.data.api.environment

/**
 * The base API environment plugin class.
 */
abstract class ApiEnvironmentPlugin {

    // region Properties

    /**
     * The [ApiEnvironment] value associated with this [ApiEnvironmentPlugin].
     */
    abstract val apiEnvironment: ApiEnvironment

    // endregion Properties

    // region Companion object

    companion object {

        // region Methods

        /**
         * Creates a new [ApiEnvironmentPlugin] based on [apiEnvironment].
         */
        fun newInstance(apiEnvironment: ApiEnvironment): ApiEnvironmentPlugin {
            return when (apiEnvironment) {
                ApiEnvironment.PROD -> ProdApiEnvironmentPlugin()
                ApiEnvironment.DEV -> DevApiEnvironmentPlugin()
                ApiEnvironment.LOCAL -> LocalApiEnvironmentPlugin()
            }
        }

        // endregion Methods
    }

    // endregion Companion object
}