clear; % clears variables
clc; % clears console
close all; % close all open figures
format long;

%M = readtable('HackOhio/data/Dorm Buildings.csv');
M = readtable('HackOhio/data/Non-Dorm Buildings.csv');

%desiredBuilding = "BuschHouse_";
desiredBuilding = "KnowltonAustinEHall_";

%buildingNames = [ "Busch House", "Taylor Tower", "Smith-Steeb Hall", "Baker Hall", "Morrill Tower"];
buildingNames = ["Knowlton Hall", "North Recreation Center", "Denny Hall", "Thompson Library", "Enarson"];
buildingNum = 1;

desiredColumns = ["SteamConsumption";
    "ElectricityConsumption";
    "ChilledWaterConsumption";
    "HotWaterConsumption";
    "TotalEnergyConsumption";
    "NaturalGasConsumption"];

columns=["Steam";"Electricity";"Chilled Water";"Hot Water";"Total Energy";"Natural Gas"];

energyMeans=[];
for i=2:numel(M.Properties.VariableNames())
    for j=1:numel(desiredColumns)
        if contains(M.Properties.VariableNames(i), desiredBuilding+desiredColumns(j))
            energyMeans(end+1) = GetAverage(M,M.Properties.VariableNames(i));
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
title(buildingNames(buildingNum) + " Categorical Energy Usage");

%print('graphs/BuschPlotCategories','-dpng');

print('KnowltonPlotCategories','-dpng');


