clear; % clears variables
clc; % clears console
close all; % close all open figures
format long;

%M = readtable('HackOhio/data/Dorm Buildings.csv');
M = readtable('HackOhio/data/Non-Dorm Buildings.csv');

%buildingNames = [ "Busch House", "Taylor Tower", "Smith-Steeb Hall", "Baker Hall", "Morrill Tower"];
buildingNames = ["Knowlton Hall", "North Recreation Center", "Denny Hall", "Thompson Library", "Enarson"];
buildingNum = 1;

averages = zeros(1,numel(M.Properties.VariableNames()));
for i=2:numel(M.Properties.VariableNames())
    averages(i)=GetAverage(M,M.Properties.VariableNames(i));
end

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

clr = [0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;];

clr(buildingNum,:) = [0.74, 0.0, 0.0];

b = bar(0.293*24*totalEnergyMeans./ocupancyMeans,'FaceColor','flat');
b.CData = clr;
ylabel("Total Daily Energy Usage per Person (kWh)");
set(gca,'xticklabel', buildingNames);
title("Average " + buildingNames(buildingNum) + " Energy Usage");

%print('graphs/BuschPlotPerPerson','-dpng');
print('KnowltonPlotPerPerson','-dpng');

%numel(M(:,"BuschHouse_ElectricityConsumption_kBTU_"))
% M(startsWith("SeriesName","2017"),"SeriesName")

%t1 = M{startsWith(string(M.SeriesName),"2017"),"BuschHouse_ElectricityConsumption_kBTU_"};

