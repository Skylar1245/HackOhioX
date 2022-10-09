function [increase] = MonthDifference(currentMonth)
%MonthDifference finds the percentage change in power over the previous two
%months for both a Dorm Building and Non-Dorm building.

    % Initialize the return value.
    increase = 0;

    % Extract the tables of data from the .csv file.
    M = readtable('HackOhio/data/Dorm Buildings.csv');
    M2 = readtable('HackOhio/data/Non-Dorm Buildings.csv');
    
    % Store a copt of the input month for referencing and alteration.
    month = currentMonth;

    % Initialize an array to contain the month string array
    monthStr = [];
    
    %Calculate the monthly averages of the months that are needed.
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

    % Find the percentage change between the two months.
    result = monthAverages(2)/monthAverages(1);
    result2 = monthAverages2(2)/monthAverages2(1);

    % Create a writer to write information to a text file.
    writer = fopen( 'HackOhio/Data/Months.txt', 'w' );
    % Print the results to a .text file.
    fprintf(writer, '%f\n', result);
    fprintf(writer, '%f', result2);
    % Close the writer.
    fclose(writer);
end