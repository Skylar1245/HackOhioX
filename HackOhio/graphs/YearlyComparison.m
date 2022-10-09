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

% Choose the desired column to graph. This is manually selected for now.
desiredColumn = "BuschHouse_TotalEnergyConsumption_Cleaned__kBTU_"; %1
%desiredColumn = "KnowltonAustinEHall_TotalEnergyConsumption_Cleaned__kBTU_"; %2

% Calcuate and store the average of all the years available on the data for
% the desired column.
years=[];
yearAverages = zeros(1,6);
for i=1:6
    year = 2016+i;
    years(end+1)=string(year);
    yeartable = M(startsWith(string(M.SeriesName),string(year)),desiredColumn);
    yearAverages(i) = GetAverage(yeartable,desiredColumn);
end

% Create the matrix of colors for the bar graph.
clr = [0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5
    0.74, 0.0, 0.0];

% Create the bar graph with appropriate units scale and labels.
b = bar(0.000000293*24*365*yearAverages,'FaceColor','flat');
b.CData = clr;
xlabel("Year");
ylabel("Total Annual Energy Usage (GWh)");
set(gca,'xticklabel', years);
title("Average Annual " + buildingNames(buildingNum) + " Energy Usage");


% Print the desired graph into the folder. Currently, the name must be
% entered in manually, and Busch House/Knowlton Hall are the examples.
print('HackOhio/graphs/BuschPlotAnnual','-dpng'); %1
%print('HackOhio/graphs/KnowltonPlotAnnual','-dpng'); %2
