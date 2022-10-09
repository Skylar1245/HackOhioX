clear; % clears variables
clc; % clears console
close all; % close all open figures


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

% Calculate and store the averages of all of the tables property columns.
averages = zeros(1,numel(M.Properties.VariableNames()));
for i=2:numel(M.Properties.VariableNames())
    averages(i)=GetAverage(M,M.Properties.VariableNames(i));
end

% Extract the total energy consumption averages and occupancy means for 
% each of the buildings.
totalEnergyMeans=[];
ocupancyMeans=[];
for i=2:numel(M.Properties.VariableNames())
    if contains(M.Properties.VariableNames(i), 'TotalEnergyConsumption')
        totalEnergyMeans(end+1) = averages(i);
    end
    if endsWith(M.Properties.VariableNames(i),'Occupancy_DEV_')
        ocupancyMeans(end+1) = averages(i);
    end
end

% Create the matrix of colors for the bar graph.
clr = [0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;];
% Change the color of the bar graph for the selected building.
clr(buildingNum,:) = [0.74, 0.0, 0.0];

% Create the bar graph with appropriate units scale and labels.
b = bar(0.293*24*totalEnergyMeans./ocupancyMeans,'FaceColor','flat');
b.CData = clr;
ylabel("Total Daily Energy Usage per Person (kWh)");
set(gca,'xticklabel', buildingNames);
title("Average " + buildingNames(buildingNum) + " Energy Usage");

% Print the desired graph into the folder. Currently, the name must be
% entered in manually, and Busch House/Knowlton Hall are the examples.
print('HackOhio/graphs/BuschPlotPerPerson','-dpng'); %1
%print('KnowltonPlotPerPerson','-dpng'); %2
