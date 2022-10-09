clear; % clears variables
clc; % clears console
close all; % close all open figures
format long;

M = readtable('HackOhio/data/Dorm Buildings.csv');

tic
averages = zeros(1,numel(M.Properties.VariableNames()));
for i=2:numel(M.Properties.VariableNames())
    averages(i)=GetAverage(M,M.Properties.VariableNames(i));
end
averages;
toc

totalEnergyMeans=[];
ocupancyMeans=[];
for i=2:numel(M.Properties.VariableNames())
    if endsWith(M.Properties.VariableNames(i), 'TotalEnergyConsumption_Cleaned__kBTU_')
        totalEnergyMeans(end+1) = averages(i);
    end
    if endsWith(M.Properties.VariableNames(i),'Occupancy_DEV_')
        ocupancyMeans(end+1) = averages(i);
    end
end

clr = [0.74, 0.0, 0.0;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;
    0.5, 0.5, 0.5;];

b = bar(0.293*24*totalEnergyMeans./ocupancyMeans,'FaceColor','flat');
b.CData = clr;
ylabel("Total Daily Energy Usage per Person (kWh)");
buildingNames = [ "Busch House", "Taylor Tower", "Smith-Steeb Hall", "Baker Hall", "Morrill Tower"];
set(gca,'xticklabel', buildingNames);
title("Average Busch House Energy Usage");

print('graphs/BuschPlotPerPerson','-dpng');

%numel(M(:,"BuschHouse_ElectricityConsumption_kBTU_"))
% M(startsWith("SeriesName","2017"),"SeriesName")

%t1 = M{startsWith(string(M.SeriesName),"2017"),"BuschHouse_ElectricityConsumption_kBTU_"};

