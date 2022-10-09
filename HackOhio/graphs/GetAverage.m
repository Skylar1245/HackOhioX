function [average] = GetAverage(table,columnName)
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here
    average = 0;
    test = table{:,columnName};
    test2 = test(~isnan(str2double(test)));
    if numel(test2)>0
        test3 = str2double(test2);
        average = mean(test3);
    elseif numel(isnan(str2double(test)))>1
        average = 0;
    else
        average = mean(test);
    end
end