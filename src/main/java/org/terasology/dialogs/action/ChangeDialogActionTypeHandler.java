/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.terasology.dialogs.action;

import java.util.Optional;

import org.terasology.persistence.typeHandling.*;

@RegisterTypeHandler
public class ChangeDialogActionTypeHandler extends TypeHandler<ChangeDialogAction> {

    @Override
    protected PersistedData serializeNonNull(ChangeDialogAction value, PersistedDataSerializer serializer) {
        return serializer.serialize(value.getPrefab());
    }

    @Override
    public Optional<ChangeDialogAction> deserialize(PersistedData data) {
        if (!data.isString()) {
            return Optional.empty();
        }
        String prefab = data.getAsString();
        return Optional.of(new ChangeDialogAction(prefab));
    }
}