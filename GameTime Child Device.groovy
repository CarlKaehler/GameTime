/**
 *  GameTime Child
 *
 *  Copyright\u00A9 2021 Justin Leonard
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 * V1.0 - Initial Release
**/

metadata
{
    definition(name: "GameTime Child", namespace: "lnjustin", author: "Justin Leonard", importUrl: "")
    {
        capability "Actuator"
        capability "Switch"
        
        attribute "gameTime", "string"
        attribute "gameTimeStr", "string"
        attribute "status", "string"        
        attribute "tile", "string"     
        attribute "opponent", "string"  
    }
}

preferences
{
    section
    {
        input name: "parentID", type: "string", title: "Parent App ID"
        input name: "logEnable", type: "bool", title: "Enable debug logging", defaultValue: true
    }
}

def logDebug(msg) 
{
    if (logEnable)
    {
        log.debug(msg)
    }
}    

def updated()
{
    configure()
}

def parse(String description)
{
    logDebug(description)
}

def configure()
{    
    refresh()
}

def updateDevice(data) {
    state.appID = data.appID
    sendEvent(name: "gameTime", value: data.gameTime)
    sendEvent(name: "gameTimeStr", value: data.gameTimeStr)
    sendEvent(name: "tile", value: data.tile)
    sendEvent(name: "status", value: data.status)
    sendEvent(name: "opponent", value: data.opponent)
    sendEvent(name: "switch", value: data.switch)
}

def getDeviceData() {
    def data = [gameTime: gameTime]    
}

def refresh()
{

}