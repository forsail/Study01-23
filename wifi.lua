local homeWifi = "TP-LINK_5G_2E25"
local workWifi = ""

function ssidChangedCallback()
    ssid = hs.wifi.currentNetwork()
    if (ssid == homeWifi) 
    then
        hs.audiodevice:setMuted(false)
        hs.alter.show("Back Home!")
    else if(ssid == workWifi) then
        hs.audiodevice:setMuted(false)
        hs.alter.show("Start work!")
    end
end


wifiWatcher = hs.wifi.watcher.new(ssidChangedCallback)
wifiWatcher:start()