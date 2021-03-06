/*******************************************************************************
 * Copyright (c) 2015 Bruno Medeiros and other Contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Bruno Medeiros - initial API and implementation
 *******************************************************************************/
package com.github.rustdt.ide.core.operations;

import com.github.rustdt.tooling.cargo.CargoTargetHelper;

import melnorme.lang.ide.core.operations.ILangOperationsListener_Default.NullOperationMonitor;
import melnorme.lang.ide.core.operations.ToolManager;
import melnorme.lang.ide.core.operations.build.BuildTarget;
import melnorme.lang.ide.core.operations.build.BuildTargetOperation;
import melnorme.lang.tooling.bundle.LaunchArtifact;
import melnorme.utilbox.core.CommonException;

public class CoreCargoTargetHelper extends CargoTargetHelper {
	
	public DebugMode getBuildMode(BuildTarget bt) throws CommonException {
		ToolManager toolManager = bt.buildMgr.getToolManager();
		BuildTargetOperation buildOp = bt.getBuildOperation(toolManager, new NullOperationMonitor());
		return getBuildMode(buildOp.getEffectiveProccessCommandLine());
	}
	
	public String getExecutablePathForCargoTarget(String cargoTargetName, BuildTarget bt) throws CommonException {
		return getExecutablePathForCargoTarget(cargoTargetName, getBuildMode(bt));
	}
	
	public LaunchArtifact getLaunchArtifactForTestTarget(BuildTarget bt, String testTargetName) 
			throws CommonException {
		return getLaunchArtifactForTestTarget(bt.getProjectLocation(), testTargetName, getBuildMode(bt));
	}
	
}