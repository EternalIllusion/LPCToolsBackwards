package lpctools.tools;

import lpctools.lpcfymasaapi.configbutton.derivedConfigs.ThirdListConfig;
import lpctools.lpcfymasaapi.implementations.ILPCConfigList;
import lpctools.tools.autoGrindstone.AutoGrindstone;
import lpctools.tools.antiSpawner.AntiSpawner;
import lpctools.tools.fillingAssistant.FillingAssistant;
import lpctools.tools.liquidCleaner.LiquidCleaner;

import static lpctools.lpcfymasaapi.LPCConfigStatics.*;

public class ToolConfigs {
    static ThirdListConfig FAConfig;
    static ThirdListConfig LCConfig;
    static ThirdListConfig AGConfig;
    static ThirdListConfig ASConfig;
    public static void init(){
        ILPCConfigList lastList = peekConfigList();
        try(ConfigListLayer layer = new ConfigListLayer()){
            layer.set(FAConfig = addThirdListConfig(lastList, "FA", false));
            FillingAssistant.init();
            layer.set(LCConfig = addThirdListConfig(lastList, "LC", false));
            LiquidCleaner.init();
            layer.set(AGConfig = addThirdListConfig(lastList, "AG", false));
            AutoGrindstone.init();
            layer.set(ASConfig = addThirdListConfig(lastList, "AS", false));
            AntiSpawner.init();
        }
    }
}
