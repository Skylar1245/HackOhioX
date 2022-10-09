clear; % clears variables
clc; % clears console
close all; % close all open figures
format long;

% Switch which statement 1/2 is is commented out to switch between Dorm and
% Non-Dorm buildings. Because functionality was prioritized over ease of
% use, there are four such 1/2 switch lines that can be changed later.

% Extract the table of data from the .csv file.
M = readtable('HackOhio/data/Dorm Buildings.csv'); %1
%M = readtable('HackOhio/data/Non-Dorm Buildings.csv'); %2

% Set the names of the buildings for output later.
buildingNames = [ "Busch House", "Taylor Tower", "Smith-Steeb Hall", "Baker Hall", "Morrill Tower"]; %1
%buildingNames = ["Knowlton Hall", "North Recreation Center", "Denny Hall", "Thompson Library", "Enarson"]; %2

% Choose which of the buildings to be focused on.
buildingNum = 1;

% Store the root of the desired building. This will need to be automated
% later to simplify the code.
desiredBuilding = "BuschHouse_";
%desiredBuilding = "KnowltonAustinEHall_";

% Inititalize the categores to compare.
desiredColumns = ["SteamConsumption";
    "ElectricityConsumption";
    "ChilledWaterConsumption";
    "HotWaterConsumption";
    "TotalEnergyConsumption";
    "NaturalGasConsumption"];

% Set the names of the columns to output later.
columns=["Steam";"Electricity";"Chilled Water";"Hot Water";"Total Energy";"Natural Gas"];

% Calculate and store the averages for each column of data for the desired
% building.
energyMeans=[];
for i=2:numel(M.Properties.VariableNames())
    for j=1:numel(desiredColumns)
        if contains(M.Properties.VariableNames(i), desiredBuilding+desiredColumns(j))
            energyMeans(end+1) = GetAverage(M,M.Properties.VariableNames(i));
        end
    end
end

% Create the matrix of colors for the bar graph.
clr = [0.74, 0.0, 0.0;
    0.74, 0.0, 0.0;
    0.74, 0.0, 0.0;
    0.74, 0.0, 0.0;
    0.74, 0.0, 0.0;
    0.74, 0.0, 0.0];

% Create the bar graph with appropriate units scale and labels.
b = bar(0.000000293*24*365*energyMeans,'FaceColor','flat');
b.CData = clr;
ylabel("Energy Usage (GWh)");
set(gca,'xticklabel', columns);
title(buildingNames(buildingNum) + " Categorical Energy Usage");

% Print the desired graph into the folder. Currently, the name must be
% entered in manually, and Busch House/Knowlton Hall are the examples.
print('HackOhio/graphs/BuschPlotCategories','-dpng'); %1
%print('HackOhio/graphs/KnowltonPlotCategories','-dpng'); %2


