clear; % clears variables
clc; % clears console
close all; % close all open figures
format long;

M = readtable('HackOhio/data/Dorm Buildings.csv');

desiredBuilding = "BuschHouse_";

desiredColumns = ["SteamConsumption_kBTU_";
    "ElectricityConsumption_kBTU_";
    "ChilledWaterConsumption_kBTU_";
    "HotWaterConsumption_kBTU_";
    "TotalEnergyConsumption_Cleaned__kBTU_";
    "NaturalGasConsumption_kBTU_"];

columns=["Steam";"Electricity";"Chilled Water";"Hot Water";"Total Energy";"Natural Gas"];

energyMeans=[];
for i=2:numel(M.Properties.VariableNames())
    for j=1:numel(desiredColumns)
        if endsWith(M.Properties.VariableNames(i), desiredBuilding+desiredColumns(j))
            energyMeans(end+1) = GetAverage(M,desiredBuilding+desiredColumns(j));
        end
    end
end

clr = [0.74, 0.0, 0.0;
    0.74, 0.0, 0.0;
    0.74, 0.0, 0.0;
    0.74, 0.0, 0.0;
    0.74, 0.0, 0.0;
    0.74, 0.0, 0.0];

b = bar(0.000000293*24*365*energyMeans,'FaceColor','flat');
b.CData = clr;
ylabel("Energy Usage (GWh)");
set(gca,'xticklabel', columns);
title("Categorical Energy Usage");

print('graphs/BuschPlotCategories','-dpng');


