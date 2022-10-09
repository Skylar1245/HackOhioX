function [average] = GetAverage(table,columnName)
%GetAverage Find the average value of the numbers in the column of a table.
    % Initialize a value for the average.
    average = 0;
    % Extract the desired column from the given table.
    test = table{:,columnName};
    % Create an array of values to know which values cannot be converted to
    % double and are not numbers.
    test2 = test(~isnan(str2double(test)));
    % Remove the strings that are not numbers from the array and then find
    % the average value of the remaining numbers.
    if numel(test2)>0
        test3 = str2double(test2);
        average = mean(test3);
        % If the entire table array is not a number, then there are no
        % numbers, so the average returns zero.
    elseif numel(isnan(str2double(test)))>1
        average = 0;
    else
        % If there are no values that are not not numbers, then all of the
        % numbers should be numbers, and the mean can be returned.
        average = mean(test);
    end
end