/*
 * -----------------------------------------------------------------------
 * Copyright 2012 - Alistair Rutherford - www.netthreads.co.uk
 * -----------------------------------------------------------------------
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.netthreads.gdx.app.scene;

import com.netthreads.gdx.app.layer.ControlLayer;
import com.netthreads.gdx.app.layer.GameLayer;
import com.netthreads.gdx.app.layer.StarsLayer;
import com.netthreads.libgdx.scene.Layer;
import com.netthreads.libgdx.scene.Scene;

/**
 * Game scene is composed of game element layers.
 * 
 */
public class GameScene extends Scene
{
	private Layer controlLayer;
	private Layer starsLayer;
	private GameLayer gameLayer;

	/**
	 * Main game scene.
	 * 
	 */
	public GameScene()
	{
		// ---------------------------------------------------------------
		// Control layer
		// ---------------------------------------------------------------
		controlLayer = new ControlLayer();

		// Route input to layer.
		getInputMultiplexer().addProcessor(controlLayer);

		addLayer(controlLayer);

		// ---------------------------------------------------------------
		// Stars layer
		// ---------------------------------------------------------------
		starsLayer = new StarsLayer(getWidth(), getHeight());
		//
		addLayer(starsLayer);

		// ---------------------------------------------------------------
		// Game layer.
		// ---------------------------------------------------------------
		gameLayer = new GameLayer(getWidth(), getHeight());

		// Route input to layer.
		getInputMultiplexer().addProcessor(gameLayer);
		
		addLayer(gameLayer);
	}
	
	/**
	 * Reset view.
	 * 
	 */
	public void reset()
	{
		gameLayer.reset();
	}

}
