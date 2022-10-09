function [increase] = MonthDifference(currentMonth)
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here

    increase = 0;

    M = readtable('HackOhio/data/Dorm Buildings.csv');
    M2 = readtable('HackOhio/data/Non-Dorm Buildings.csv');
    
    %buildingNames = ["Busch House", "Taylor Tower", "Smith-Steeb Hall", "Baker Hall", "Morrill Tower"];
    %buildingNames = ["Knowlton Hall", "North Recreation Center", "Denny Hall", "Thompson Library", "Enarson"];
    buildingNum = 1;
    
    desiredColumn = "BuschHouse_TotalEnergyConsumption_Cleaned__kBTU_";
    desiredColumn2 = "KnowltonAustinEHall_TotalEnergyConsumption_Cleaned__kBTU_";

    month = currentMonth;

    monthStr = [];
    
    monthAverages = zeros(1,2);
    monthAverages2 = zeros(1,2);
    year = string(2022) + "-";
    for i=1:2
        month = month - 1;
        if month == 0
            month = 12;
        end
        if month < 10
            monthStr = "0" + string(month);
        else
            monthStr = string(month);
        end
        monthtable = M(startsWith(string(M.SeriesName),year+monthStr),desiredColumn);
        monthtable2 = M2(startsWith(string(M.SeriesName),year+monthStr),desiredColumn2);
        monthAverages(i) = GetAverage(monthtable,desiredColumn);
        monthAverages2(i) = GetAverage(monthtable2,desiredColumn2);
    end
    result = monthAverages(2)/monthAverages(1)
    result2 = monthAverages2(2)/monthAverages2(1)

    writer = fopen( 'HackOhio/Data/Months.txt', 'w' );
    fprintf(writer, '%f\n', result);
    fprintf(writer, '%f', result2);
    fclose(writer);
end