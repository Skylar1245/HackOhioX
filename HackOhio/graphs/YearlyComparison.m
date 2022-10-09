clear; % clears variables
clc; % clears console
close all; % close all open figures
format long;

%M = readtable('HackOhio/data/Dorm Buildings.csv');
M = readtable('HackOhio/data/Non-Dorm Buildings.csv');

%buildingNames = [ "Busch House", "Taylor Tower", "Smith-Steeb Hall", "Baker Hall", "Morrill Tower"];
buildingNames = ["Knowlton Hall", "North Recreation Center", "Denny Hall", "Thompson Library", "Enarson"];
buildingNum = 1;

%desiredColumn = "BuschHouse_TotalEnergyConsumption_Cleaned__kBTU_";
desiredColumn = "KnowltonAustinEHall_TotalEnergyConsumption_Cleaned__kBTU_";

years=[];
yearAverages = zeros(1,6);
for i=1:6
    year = 2016+i;
    years(end+1)=string(year);
    yeartable = M(startsWith(string(M.SeriesName),string(year)),desiredColumn);
    yearAverages(i) = GetAverage(yeartable,desiredColumn);
end

clr = [0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5
    0.74, 0.0, 0.0];

b = bar(0.000000293*24*365*yearAverages,'FaceColor','flat');
b.CData = clr;
xlabel("Year");
ylabel("Total Annual Energy Usage (GWh)");
set(gca,'xticklabel', years);
title("Average Annual " + buildingNames(buildingNum) + " Energy Usage");

%print('graphs/BuschPlotAnnual','-dpng');

print('KnowltonPlotAnnual','-dpng');
